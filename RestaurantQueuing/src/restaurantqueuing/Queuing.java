package restaurantqueuing;

import edu.sit.cs.db.CSDbDelegate;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Queuing {

    public Queuing() {
        db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G5", "csc105_2014", "csc105");
        System.out.println(db.connect());
    }

    public int checkAvailable(Date date, Date time, int chairs) throws ParseException {
        int tableId = -1;

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String reserve = dateFormat.format(date) + " " + timeFormat.format(time);
        Calendar dateTimeReserve = new GregorianCalendar();
        dateTimeReserve.setTime(dateTimeFormat.parse(reserve));
        dateTimeReserve.add(Calendar.YEAR, -543);

        Calendar currentTime = new GregorianCalendar();
        currentTime.add(Calendar.YEAR, -543);
        currentTime.add(Calendar.MINUTE, 59);

        Calendar openTime = new GregorianCalendar();
        openTime.setTime(timeFormat.parse("07:59"));

        Calendar closeTime = new GregorianCalendar();
        closeTime.setTime(timeFormat.parse("20:01"));

        boolean beforeOneHour = dateTimeReserve.getTime().before(currentTime.getTime());
        boolean beforeOpen = time.before(openTime.getTime());
        boolean afterClose = time.after(closeTime.getTime());

        if (beforeOneHour) {
            return -3;
        }

        if (beforeOpen || afterClose) {
            return -2;
        }

        String tableIdSql = "SELECT tableID, available FROM R_TABLES WHERE chairs = " + chairs;
        ArrayList<HashMap> tables = db.queryRows(tableIdSql);

        for (HashMap table : tables) {
            if (Integer.parseInt(String.valueOf(table.get("available"))) == 1) {
                tableId = Integer.parseInt(String.valueOf(table.get("tableID")));
                CheckAvailable.setDateTimeReserve(dateTimeReserve);
                return tableId;
            }
        }

        if (tableId == -1) {
            for (HashMap table : tables) {
                tableIdSql = "SELECT dateTimeReserve, tableID FROM R_ORDERS WHERE tableID = " + table.get("tableID");
                HashMap tables2 = db.queryRow(tableIdSql);

                Calendar minDate = new GregorianCalendar();
                minDate.setTime(dateTimeFormat.parse(String.valueOf(tables2.get("dateTimeReserve"))));
                minDate.add(Calendar.HOUR_OF_DAY, -2);

                Calendar maxDate = new GregorianCalendar();
                maxDate.setTime(dateTimeFormat.parse(String.valueOf(tables2.get("dateTimeReserve"))));
                maxDate.add(Calendar.HOUR_OF_DAY, 2);

                if (dateTimeReserve.getTime().before(minDate.getTime()) || dateTimeReserve.getTime().after(maxDate.getTime())) {
                    tableId = Integer.parseInt(String.valueOf(tables2.get("tableID")));
                    CheckAvailable.setDateTimeReserve(dateTimeReserve);
                    return tableId;
                }
            }
        }
        CheckAvailable.setDateTimeReserve(dateTimeReserve);
        return tableId;
    }

    public int getCustomerId(String name) {
        String sql = "SELECT * FROM R_CUSTOMERS";
        ArrayList<HashMap> customers = db.queryRows(sql);

        for (HashMap customer : customers) {
            if (customer.get("customerName").equals(name)) {
                return Integer.parseInt(String.valueOf(customer.get("customerID")));
            }
        }

        sql = "INSERT INTO R_CUSTOMERS(customerID, customerName) VALUES("
                + (customers.size() + 1) + ", '"
                + name + "' "
                + ")";
        db.executeQuery(sql);
        return customers.size() + 1;
    }

    public String getCustomerName(int id) {
        String sql = "SELECT customerName FROM R_CUSTOMERS WHERE customerID = " + id;
        HashMap name = db.queryRow(sql);

        return String.valueOf(name.get("customerName"));
    }

    public int getFoodId(String foodName) {
        String sql = "SELECT foodID FROM R_FOODS WHERE foodName = '" + foodName + "'";
        HashMap foodId = db.queryRow(sql);
        return Integer.parseInt(String.valueOf(foodId.get("foodID")));
    }

    public ArrayList<HashMap> getOrders(Date d) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar date = new GregorianCalendar();
        date.setTime(d);
        date.add(Calendar.YEAR, -543);
        String strDate = dateFormat.format(date.getTime());

        String sql = "SELECT * FROM R_ORDERS WHERE "
                + "dateTimeReserve > '" + strDate + " 00:00:00' AND "
                + "dateTimeReserve < '" + strDate + " 23:00:00' "
                + "ORDER BY dateTimeReserve ASC";
        ArrayList<HashMap> allOrders = db.queryRows(sql);

        ArrayList<HashMap> tables = null;
        int line = 0;

        for (HashMap order : allOrders) {
            if (tables == null) {
                tables = new ArrayList<HashMap>();
                tables.add(order);
                line++;
                continue;
            }
            if (Integer.parseInt(String.valueOf(order.get("tableID"))) == Integer.parseInt(String.valueOf(tables.get(line - 1).get("tableID")))
                    && Integer.parseInt(String.valueOf(order.get("customerID"))) == Integer.parseInt(String.valueOf(tables.get(line - 1).get("customerID")))); else {
                tables.add(order);
                line++;
            }
        }
        return tables;
    }

    public ArrayList<HashMap> getBilling(int tableId, String customerName) {
        String sql = "SELECT customerID FROM R_CUSTOMERS WHERE customerName = '" + customerName + "'";
        HashMap cName = db.queryRow(sql);

        int id = Integer.parseInt(String.valueOf(cName.get("customerID")));
        sql = "SELECT foodID, quantity FROM R_ORDERS WHERE tableID = " + tableId + " AND "
                + "customerID = " + id;
        ArrayList<HashMap> orders = db.queryRows(sql);

        ArrayList<HashMap> billing = new ArrayList<HashMap>();

        for (HashMap order : orders) {
            sql = "SELECT foodName, price FROM R_FOODS WHERE foodID = " + Integer.parseInt(String.valueOf(order.get("foodID")));
            HashMap data = db.queryRow(sql);

            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("qty", order.get("quantity"));
            hashMap.put("foodName", data.get("foodName"));
            hashMap.put("total", Integer.parseInt(String.valueOf(order.get("quantity"))) * Integer.parseInt(String.valueOf(data.get("price"))));

            billing.add(hashMap);
        }

        return billing;
    }

    public void insertOrders(String dateTimeReserve, String timeOut, int foodId, int quantity, int tableId, int customerId) {
        String sql = "INSERT INTO R_ORDERS(dateTimeReserve, timeOut, foodID, quantity, tableID, customerID) VALUES ( '"
                + dateTimeReserve + " ', '"
                + timeOut + " ', "
                + foodId + ", "
                + quantity + ", "
                + tableId + ", "
                + customerId
                + " )";
        db.executeQuery(sql);
    }

    public void removeOrders(String currentTime, int tableNo) {
        String sql = "SELECT tableID FROM R_ORDERS WHERE timeOut <= '" + currentTime + "' ";
        ArrayList<HashMap> tables = db.queryRows(sql);

        sql = "DELETE FROM R_ORDERS WHERE timeOut <= '" + currentTime + "' AND tableID = " + tableNo;
        db.executeQuery(sql);

        for (HashMap table : tables) {
            sql = "SELECT tableID FROM R_ORDERS WHERE tableID = " + Integer.parseInt(String.valueOf(table.get("tableID")));
            HashMap t = db.queryRow(sql);
            if (t.isEmpty()) {
                sql = "UPDATE R_TABLES SET available = true WHERE tableID = " + Integer.parseInt(String.valueOf(table.get("tableID")));
                db.executeQuery(sql);
            }
        }
    }

    public ArrayList<HashMap> getBacklogADay(String date) {
        String sql = "SELECT * FROM R_BACKLOG";
        ArrayList<HashMap> backlogs = db.queryRows(sql);

        double total = 0;
        ArrayList<HashMap> aday = new ArrayList<HashMap>();

        for (HashMap backlog : backlogs) {
            String s = String.valueOf(backlog.get("date")).substring(0, 7);

            if (s.equals(date)) {
                total += Double.parseDouble(String.valueOf(backlog.get("revenue")));
                HashMap<String, Object> hashMap = new HashMap<String, Object>();
                hashMap.put("date", String.valueOf(backlog.get("date")));
                hashMap.put("noOfCustomer", String.valueOf(backlog.get("noOfCustomer")));
                hashMap.put("revenue", String.valueOf(backlog.get("revenue")));
                hashMap.put("total", total);

                aday.add(hashMap);
            }
        }

        return aday;
    }
    
    public ArrayList<HashMap> getPopularFoods() {
        String sql = "SELECT foodName FROM R_FOODS WHERE foodID > 201 AND foodID < 300 ORDER BY ordered DESC";
        return db.queryRows(sql);
    }
    
    public ArrayList<HashMap> getPopularSnacks() {
        String sql = "SELECT foodName FROM R_FOODS WHERE foodID > 300 ORDER BY ordered DESC";
        return db.queryRows(sql);
    }

    public ArrayList<HashMap> getBacklogAMonth(String year) {
        String sql = "SELECT * FROM R_BACKLOG";
        ArrayList<HashMap> backlogs = db.queryRows(sql);

        ArrayList<HashMap> months = new ArrayList<HashMap>();
        for (HashMap backlog : backlogs) {
            String y = String.valueOf(backlog.get("date")).substring(0, 4);
            if (y.equals(year)) {
                HashMap<String, Object> hashMap = new HashMap<String, Object>();
                hashMap.put("month", String.valueOf(backlog.get("date")).substring(5, 7));
                hashMap.put("noOfCustomer", String.valueOf(backlog.get("noOfCustomer")));
                hashMap.put("revenue", String.valueOf(backlog.get("revenue")));

                months.add(hashMap);
            }
        }
        
        ArrayList<HashMap> amonth = new ArrayList<HashMap>();
        String[] month = {"January", "Fabuary", "March", "April", "May", "June", "July", "September", "October", "November", "December"}; 
        for(HashMap m : months) {
            for(int i = 0; i < month.length; i++) {
                
            }
        }
        
        return amonth;
    }

    public void updateBacklog(String date, double revenue, int chairs) {
        String sql = "SELECT * FROM R_BACKLOG WHERE date = '" + date + "'";
        HashMap d = db.queryRow(sql);

        if (d.isEmpty()) {
            sql = "INSERT INTO R_BACKLOG(date, revenue, noOfCustomer) VALUES( '"
                    + date + "', "
                    + revenue + ", "
                    + chairs + ") ";
            db.executeQuery(sql);
        } else {
            revenue += Double.parseDouble(String.valueOf(d.get("revenue")));
            chairs += Integer.parseInt(String.valueOf(d.get("noOfCustomer")));
            sql = "UPDATE R_BACKLOG SET revenue = " + revenue + ", noOfCustomer = " + chairs + " WHERE date = '" + date + "'";
            db.executeQuery(sql);
        }
    }

    public void updateStatusTable(int tableId) {
        String sql = "UPDATE R_TABLES SET available = false WHERE tableID = " + tableId;
        db.executeQuery(sql);
    }

    public void updatePopularFood(int qty, String foodName) {
        String sql = "SELECT ordered FROM R_FOODS WHERE foodName = '" + foodName + "'";
        HashMap food = db.queryRow(sql);

        int ordered = qty + Integer.parseInt(String.valueOf(food.get("ordered")));
        sql = "UPDATE R_FOODS SET ordered = " + ordered + " WHERE foodName = '" + foodName + "'";
        db.executeQuery(sql);
    }

    public static void disConnectDb() {
        System.out.println(db.disconnect());
    }

    private static CSDbDelegate db;
}
