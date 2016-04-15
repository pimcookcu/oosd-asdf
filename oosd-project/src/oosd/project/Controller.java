/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oosd.project;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.HashMap;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.EventQueue;

import java.text.NumberFormat;
import java.text.ParseException;

/**
 *
 * @author BestDark
 */
public class Controller extends JFrame{
    // Snacks menu button
    private JButton btnFriedFishPasteBalls, btnCharcoalBoiledPorkNeck, btnFriedChicken,
            btnFriedPorkRind, btnCrispyWonton, btnSteamedSpringRoll;
    
    // Foods menu button
    private JButton btnRice, btnCasseroledPrawns, btnSteamedDuck, btnFriedFishToppedWithChilliSauce,
            btnSpicyVermicelliSalad, btnChickenGreenCurry, btnClearSoup, btnMincedPorkOmelet,
            btnFriedCrabinYellowCurry, btnDeepFriendShrimpCakes, btnTomYumKung;

    // Beverages menu button
    private JButton btnWater, btnPepsi, btnSprite, btnFanta, btnSoda, btnGreenTea;
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
           Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controller().setVisible(true);
            }
        });
    }
    
    private void initComponents() {

        pnlMenuBar = new JPanel();
        btnReserve = new JButton();
        btnBilling = new JButton();
        btnBacklog = new JButton();
        pnlContent = new JPanel();
        jPanel3 = new JPanel();
        jLabel1 = new JLabel();
        lblClock = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(new Rectangle(100, 100, 0, 0));
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                //formWindowClosing(evt);
            }
        });
        //getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenuBar.setPreferredSize(new Dimension(800, 70));

        setFontText(btnReserve, "Tahoma", 0, 18, "RESERVE");// NOI18N
        btnReserve.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                //btnReserveMouseClicked(evt);
            }
        });

        setFontText(btnBilling, "Tahoma", 0, 18, "BILLING");// NOI18N
        btnBilling.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                //btnBillingMouseClicked(evt);
            }
        });

        setFontText(btnBacklog, "Tahoma", 0, 18, "BACKLOG");// NOI18N
        btnBacklog.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                //btnBacklogMouseClicked(evt);
            }
        });

        GroupLayout pnlMenuBarLayout = new GroupLayout(pnlMenuBar);
        pnlMenuBar.setLayout(pnlMenuBarLayout);
        pnlMenuBarLayout.setHorizontalGroup(
            pnlMenuBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReserve, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBilling, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBacklog, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(484, Short.MAX_VALUE))
        );
        pnlMenuBarLayout.setVerticalGroup(
            pnlMenuBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btnReserve, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(btnBilling, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBacklog, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        //getContentPane().add(pnlMenuBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 855, -1));

        pnlContent.setPreferredSize(new Dimension(0, 500));

        GroupLayout pnlContentLayout = new GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 855, Short.MAX_VALUE)
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addGap(0, 525, Short.MAX_VALUE)
        );

        //getContentPane().add(pnlContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 114, 855, 525));

        jPanel3.setBackground(new Color(204, 204, 204));

        jLabel1.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Chew ID : ");

        lblClock.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        lblClock.setHorizontalAlignment(SwingConstants.RIGHT);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(429, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(130, 130, 130)
                .addComponent(lblClock, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblClock, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        );

        //getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 77, -1, -1));

        pack();
    }
    
    private void setFontText(JButton b, String f, int i, int j, String n){
        b.setFont(new Font(f, i, j)); // NOI18N
        b.setText(n);
        b.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
    }
    
    HashMap<String, JButton> snackButtons, foodButtons;
    
    //Snake set
        private void snakeButton(){   
        snackButtons = new HashMap<String, JButton>();
        
        snackButtons.put("Fried Fish-Paste Balls", btnFriedFishPasteBalls);
        setButton(btnFriedFishPasteBalls, "Fried Fish-Paste Balls", 170, 50, 85.0);
        
        snackButtons.put("Charcoal-Boiled Pork Neck", btnCharcoalBoiledPorkNeck);
        setButton(btnCharcoalBoiledPorkNeck, "Charcoal-Boiled Pork Neck", 170, 50, 110.0);
        
        snackButtons.put("Fried Chicken", btnFriedChicken);
        setButton(btnFriedChicken, "Fried Chicken", 170, 50, 60.0);
        
        snackButtons.put("Fried Pork Rind", btnFriedPorkRind);    
        setButton(btnFriedPorkRind, "Fried Pork Rind", 170, 50, 70.0);
        
        snackButtons.put("Crispy Wonton", btnCrispyWonton);
        setButton(btnCrispyWonton, "Crispy Wonton", 170, 50, 60.0);
        
        snackButtons.put("Steamed Spring Roll", btnSteamedSpringRoll);
        setButton(btnSteamedSpringRoll, "Steamed Spring Roll", 170, 50, 60.0);
    }
    
    //Food set
    private void foodButton(){
        foodButtons = new HashMap<String, JButton>();

        foodButtons.put("Rice", btnRice);
        setButton(btnRice, "Rice", 170, 50, 30.0);
        
        foodButtons.put("Casseroled Prawns", btnCasseroledPrawns);
        setButton(btnCasseroledPrawns, "Casseroled Prawns", 170, 50, 120.0);
        
        foodButtons.put("Steamed Duck", btnSteamedDuck);
        setButton(btnSteamedDuck, "Steamed Duck", 170, 50, 120.0);
        
        foodButtons.put("Fried Fish Topped With Chilli Sauce", btnFriedFishToppedWithChilliSauce);
        setButton(btnFriedFishToppedWithChilliSauce, "Fried Fish Topped With Chilli Sauce", 170, 50, 220.0);
        
        foodButtons.put("Spicy Vermicelli Salad", btnSpicyVermicelliSalad);
        setButton(btnSpicyVermicelliSalad, "Spicy Vermicelli Salad", 170, 50, 120.0);
        
        foodButtons.put("Chicken Green Curry", btnChickenGreenCurry);
        setButton(btnChickenGreenCurry, "Chicken Green Curry", 170, 50, 130.0);
        
        foodButtons.put("Clear Soup", btnClearSoup);
        setButton(btnClearSoup, "Clear Soup", 170, 50, 90.0);
        
        foodButtons.put("Minced Pork Omelet", btnMincedPorkOmelet);
        setButton(btnMincedPorkOmelet, "Minced Pork Omelet", 170, 50, 160.0);
        
        foodButtons.put("Fried Crab in Yellow Curry", btnFriedCrabinYellowCurry);
        setButton(btnFriedCrabinYellowCurry, "Fried Crab in Yellow Curry", 170, 50, 190.0);
        
        foodButtons.put("Deep-Friend Shrimp Cakes", btnDeepFriendShrimpCakes);
        setButton(btnDeepFriendShrimpCakes, "Deep-Friend Shrimp Cakes", 170, 50, 180.0);
        
        foodButtons.put("Tom Yum Kung", btnTomYumKung);
        setButton(btnTomYumKung, "Tom Yum Kung", 170, 50, 180.0);
        
        // Beverages 
        setButtonMenu(btnWater, "Water", 170, 50 ,15.0);
        setButtonMenu(btnPepsi, "Pepsi", 170, 50 ,25.0);
        setButtonMenu(btnSprite, "Sprite", 170, 50 ,25.0);
        setButtonMenu(btnSoda, "Soda", 170, 50 ,25.0);
        setButtonMenu(btnGreenTea, "GreenTea", 170, 50 ,35.0);
    }
    
    private void setButton(JButton n, String s, int x, int y, double i){
        n.setText(s);
        n.setToolTipText(s);
        n.setPreferredSize(new Dimension(x, y));
        n.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblFoodMenuLine(n, i);
            }
        });
    }
       
    private void addtblFoodMenuLine(JButton btn, double price) {
        DefaultTableModel model = (DefaultTableModel) tblFoodMenu.getModel();
        int i = 0;

        for (i = 0; i < model.getRowCount(); i++) {
            if (btn.getText().equals(model.getValueAt(i, 1))) {
                model.setValueAt(Integer.parseInt(String.valueOf((model.getValueAt(i, 3)))) + 1, i, 3);
                model.setValueAt(putComma(price * removeComma(String.valueOf(model.getValueAt(i, 3)))), i, 4);
                break;
            }
        }

        if (model.getRowCount() == 0 || i >= model.getRowCount()) {
            model.addRow(new Object[0]);
            tblFoodMenu.setValueAt(model.getRowCount(), model.getRowCount()-1, 0);
            tblFoodMenu.setValueAt(btn.getText(), model.getRowCount()-1, 1);
            tblFoodMenu.setValueAt(price + "0.-", model.getRowCount()-1, 2);
            tblFoodMenu.setValueAt(1, model.getRowCount()-1, 3);
            tblFoodMenu.setValueAt(price + "0.-", model.getRowCount()-1, 4);
        }

        computePrice(lblTotalFoodPrice, price, "+");
        computePrice(lblTotalPrice, price, "+");
    }
    
    private void addtblBeverageMenuLine(JButton btn, double price) {
        DefaultTableModel model = (DefaultTableModel) tblBeverageMenu.getModel();
        int i = 0;

        for (i = 0; i < model.getRowCount(); i++) {
            if (btn.getText().equals(model.getValueAt(i, 1))) {
                model.setValueAt(Integer.parseInt(String.valueOf((model.getValueAt(i, 3)))) + 1, i, 3);
                model.setValueAt(putComma(price * removeComma(String.valueOf(model.getValueAt(i, 3)))), i, 4);
                break;
            }
        }

        if (model.getRowCount() == 0 || i >= model.getRowCount()) {
            model.addRow(new Object[0]);
            tblBeverageMenu.setValueAt(model.getRowCount(), model.getRowCount()-1, 0);
            tblBeverageMenu.setValueAt(btn.getText(), model.getRowCount()-1, 1);
            tblBeverageMenu.setValueAt(price + "0.-", model.getRowCount()-1, 2);
            tblBeverageMenu.setValueAt(1, model.getRowCount()-1, 3);
            tblBeverageMenu.setValueAt(price + "0.-", model.getRowCount()-1, 4);
        }

        computePrice(lblTotalBeveragePrice, price, "+");
        computePrice(lblTotalPrice, price, "+");
    }
    
    private int removeComma(String str) {
        int num = 0;
        try {
            NumberFormat format = NumberFormat.getInstance(java.util.Locale.getDefault());
            Number number = format.parse(str);
            num = number.intValue();
        } catch (ParseException e) {
        }
        return num;
    }
    
    private void computePrice(JLabel label, double price, String sign) {
        double totalPrice = 0;
        if (label.getText().equals("")) {
            totalPrice = price;
        } else {
            switch (sign) {
                case "+":
                    totalPrice = removeComma(String.valueOf(label.getText())) + price;
                    break;
                case "-":
                    totalPrice = removeComma(String.valueOf(label.getText())) - price;
            }
        }
        if (totalPrice == 0) {
            label.setText("");
        } else {
            label.setText(putComma(totalPrice));
        }
    }
    
    private String putComma(double num) {
        String s = String.valueOf(num);
        String res = "";
        if (s.length() <= 5) {
            return s + "0.-";
        } else {
            int cnt = 0;
            for (int i = s.length() - 3; i >= 0; i--) {
                cnt++;
                res = s.charAt(i) + res;
                if (cnt == 3 && i > 0) {
                    res = "," + res;
                    cnt = 0;
                }
            }
            return res + ".00.-";
        }
    }
    
    //private static Queuing queue;
    private boolean clickedEnter, clickedADay, clickedAMonth;

    private static int tableId;
    private static java.sql.Timestamp dateTimeReserve, timeOut;
    private int customerId;

    // Variables declaration - do not modify                     
    private JButton btnBacklog;
    private JButton btnBilling;
    private JButton btnReserve;
    private JLabel jLabel1;
    private JPanel jPanel3;
    private JLabel lblClock;
    private JPanel pnlContent;
    private JPanel pnlMenuBar;
    // End of variables declaration                   
    
    // Variable of reserve's part
    private JButton btnBeverages, btnCheck, btnClear, btnDone, btnFoods, btnSnacks, btnPopularFood;
    private JLabel jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel8,
            lblDate, lblTime, lblTotalFoodPrice, lblTotalBeveragePrice, lblTotalPrice;
    private JPanel jPanel1, jPanel2, jPanel4, jPanel5, jPanel6, jPanel7,
            pnlMenuButton, pnlTableMenu, pnlSnackPopular, pnlFoodPopular;
    private JScrollPane jScrollPane1, jScrollPane2, jScrollPane3;
    private static JLabel lblReserve, lblTableNo;
    private JTable tblFoodMenu, tblBeverageMenu;
    private JTextField txtName;

    // Variable of billing's part
    private JButton btn0, btn00, btn000,
            btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnClearBill, btnBack, btnCE, btnDis10, btnDis20,
            btnBillingDone, btnEnter, btnCheckTable;
    private JLabel jLabel7, jLabel9, jLabel10, jLabel14, jLabel15, jLabel16,
            lblCash, lblChange, lblCustomerName, lblTable, lblTotal, lbldateTime;
    private JPanel jPanel8, jPanel9, jPanel10, jPanel11, jPanel12, jPanel13, jPanel14, jPanel15, jPanel16;
    private JScrollPane jScrollPane4, jScrollPane5;
    private JSpinner spnDate;
    private JTable tblBilling, tblgetTables;
    
    // Variable of backlog's part
    private JButton btnADay, btnAMonth, btnCheckBacklog;
    private JPanel jPanel17, jPanel18, jPanel19;
    private JScrollPane jScrollPane6;
    private JSpinner spnBacklog;
    private JTable tblBacklog;
}
