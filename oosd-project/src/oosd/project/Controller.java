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
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
           Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Control().setVisible(true);
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

        btnReserve.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        btnReserve.setText("RESERVE");
        btnReserve.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        btnReserve.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                //btnReserveMouseClicked(evt);
            }
        });

        btnBilling.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        btnBilling.setText("BILLING");
        btnBilling.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        btnBilling.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                //btnBillingMouseClicked(evt);
            }
        });

        btnBacklog.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        btnBacklog.setText("BACKLOG");
        btnBacklog.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
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
    
    HashMap<String, JButton> snackButtons, foodButtons;
    
    //Snake set
    private void snakeButton(){   
        snackButtons = new HashMap<String, JButton>();
        
        snackButtons.put("Fried Fish-Paste Balls", btnFriedFishPasteBalls);
        snackButtons.put("Charcoal-Boiled Pork Neck", btnCharcoalBoiledPorkNeck);
        snackButtons.put("Fried Chicken", btnFriedChicken);
        snackButtons.put("Fried Pork Rind", btnFriedPorkRind);
        snackButtons.put("Crispy Wonton", btnCrispyWonton);
        snackButtons.put("Steamed Spring Roll", btnSteamedSpringRoll);
    }
     
    private void friedFishButton(){    
        btnFriedFishPasteBalls.setText("Fried Fish-Paste Balls");
        btnFriedFishPasteBalls.setToolTipText("Fried Fish-Paste Balls");
        btnFriedFishPasteBalls.setPreferredSize(new Dimension(170, 50));
        btnFriedFishPasteBalls.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblFoodMenuLine(btnFriedFishPasteBalls, 85.0);
            }
        });
    }
    
    private void charcoalButton(){
        btnCharcoalBoiledPorkNeck.setText("Charcoal-Boiled Pork Neck");
        btnCharcoalBoiledPorkNeck.setToolTipText("Charcoal-Boiled Pork Neck");
        btnCharcoalBoiledPorkNeck.setPreferredSize(new Dimension(170, 50));
        btnCharcoalBoiledPorkNeck.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblFoodMenuLine(btnCharcoalBoiledPorkNeck, 110.0);
            }
        });
    }
    
    private void firedChickenButton(){
        btnFriedChicken.setText("Fried Chicken");
        btnFriedChicken.setToolTipText("Fried Chicken");
        btnFriedChicken.setPreferredSize(new Dimension(170, 50));
        btnFriedChicken.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblFoodMenuLine(btnFriedChicken, 60.0);
            }
        });
    }
    
    private void firedPorkButton(){
        btnFriedPorkRind.setText("Fried Pork Rind");
        btnFriedPorkRind.setToolTipText("Fried Pork Rind");
        btnFriedPorkRind.setPreferredSize(new Dimension(170, 50));
        btnFriedPorkRind.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblFoodMenuLine(btnFriedPorkRind, 70.0);
            }
        });
    }
    
    private void crispyWontonButton(){
        btnCrispyWonton.setText("Crispy Wonton");
        btnCrispyWonton.setToolTipText("Crispy Wonton");
        btnCrispyWonton.setPreferredSize(new Dimension(170, 50));
        btnCrispyWonton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblFoodMenuLine(btnCrispyWonton, 60.0);
            }
        });
    }
    
    private void steamedSoringButton(){
        btnSteamedSpringRoll.setText("Steamed Spring Roll");
        btnSteamedSpringRoll.setToolTipText("Steamed Spring Roll");
        btnSteamedSpringRoll.setPreferredSize(new Dimension(170, 50));
        btnSteamedSpringRoll.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblFoodMenuLine(btnSteamedSpringRoll, 60.0);
            }
        });
    }
    
    //Food set
    private void foodButton(){
        foodButtons = new HashMap<String, JButton>();

        foodButtons.put("Rice", btnRice);
        foodButtons.put("Casseroled Prawns", btnCasseroledPrawns);
        foodButtons.put("Steamed Duck", btnSteamedDuck);
        foodButtons.put("Fried Fish Topped With Chilli Sauce", btnFriedFishToppedWithChilliSauce);
        foodButtons.put("Spicy Vermicelli Salad", btnSpicyVermicelliSalad);
        foodButtons.put("Chicken Green Curry", btnChickenGreenCurry);
        foodButtons.put("Clear Soup", btnClearSoup);
        foodButtons.put("Minced Pork Omelet", btnMincedPorkOmelet);
        foodButtons.put("Fried Crab in Yellow Curry", btnFriedCrabinYellowCurry);
        foodButtons.put("Deep-Friend Shrimp Cakes", btnDeepFriendShrimpCakes);
        foodButtons.put("Tom Yum Kung", btnTomYumKung);
    }
    
    private void riceButton(){          
        btnRice.setText("Rice");
        btnRice.setToolTipText("Rice");
        btnRice.setPreferredSize(new Dimension(170, 50));
        btnRice.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblFoodMenuLine(btnRice, 30.0);
            }
        });
    }
    
    private void casseroledButton(){
        btnCasseroledPrawns.setText("Casseroled Prawns");
        btnCasseroledPrawns.setToolTipText("Casseroled Prawns");
        btnCasseroledPrawns.setPreferredSize(new Dimension(170, 50));
        btnCasseroledPrawns.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblFoodMenuLine(btnCasseroledPrawns, 120.0);
            }
        });
    }
    
    private void steamedButton(){
        btnSteamedDuck.setText("Steamed Duck");
        btnSteamedDuck.setToolTipText("Steamed Duck");
        btnSteamedDuck.setPreferredSize(new Dimension(170, 50));
        btnSteamedDuck.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblFoodMenuLine(btnSteamedDuck, 120.0);
            }
        });
    }

    private void friedFishToppedButton(){ 
        btnFriedFishToppedWithChilliSauce.setText("Fried Fish Topped With Chilli Sauce");
        btnFriedFishToppedWithChilliSauce.setToolTipText("Fried Fish Topped With Chilli Sauce");
        btnFriedFishToppedWithChilliSauce.setPreferredSize(new Dimension(170, 50));
        btnFriedFishToppedWithChilliSauce.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblFoodMenuLine(btnFriedFishToppedWithChilliSauce, 220.0);
            }
        });
    }
    
    private void spicyVermicellButton(){
        btnSpicyVermicelliSalad.setText("Spicy Vermicelli Salad");
        btnSpicyVermicelliSalad.setToolTipText("Spicy Vermicelli Salad");
        btnSpicyVermicelliSalad.setPreferredSize(new Dimension(170, 50));
        btnSpicyVermicelliSalad.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblFoodMenuLine(btnSpicyVermicelliSalad, 120.0);
            }
        });
    }

    private void chickenGreenButton(){
        btnChickenGreenCurry.setText("Chicken Green Curry");
        btnChickenGreenCurry.setToolTipText("Chicken Green Curry");
        btnChickenGreenCurry.setPreferredSize(new Dimension(170, 50));
        btnChickenGreenCurry.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblFoodMenuLine(btnChickenGreenCurry, 130.0);
            }
        });
    }
        
    private void clearSoupButton(){
        btnClearSoup.setText("Clear Soup");
        btnClearSoup.setToolTipText("Clear Soup");
        btnClearSoup.setPreferredSize(new Dimension(170, 50));
        btnClearSoup.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblFoodMenuLine(btnClearSoup, 90.0);
            }
        });
    }
    
    private void mincedPorkButton(){
        btnMincedPorkOmelet.setText("Minced Pork Omelet");
        btnMincedPorkOmelet.setToolTipText("Minced Pork Omelet");
        btnMincedPorkOmelet.setPreferredSize(new Dimension(170, 50));
        btnMincedPorkOmelet.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblFoodMenuLine(btnMincedPorkOmelet, 160.0);
            }
        });
    }
    
    private void friedCrabinButton(){
        btnFriedCrabinYellowCurry.setText("Fried Crab in Yellow Curry");
        btnFriedCrabinYellowCurry.setToolTipText("Fried Crab in Yellow Curry");
        btnFriedCrabinYellowCurry.setPreferredSize(new Dimension(170, 50));
        btnFriedCrabinYellowCurry.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblFoodMenuLine(btnFriedCrabinYellowCurry, 190.0);
            }
        });
    }

    private void deepFriendButton(){
        btnDeepFriendShrimpCakes.setText("Deep-Friend Shrimp Cakes");
        btnDeepFriendShrimpCakes.setToolTipText("Deep-Friend Shrimp Cakes");
        btnDeepFriendShrimpCakes.setPreferredSize(new Dimension(170, 50));
        btnDeepFriendShrimpCakes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblFoodMenuLine(btnDeepFriendShrimpCakes, 180.0);
            }
        });
    }

    private void tomYumKungButton(){  
        btnTomYumKung.setText("Tom Yum Kung");
        btnTomYumKung.setToolTipText("Tom Yum Kung");
        btnTomYumKung.setPreferredSize(new Dimension(170, 50));
        btnTomYumKung.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblFoodMenuLine(btnTomYumKung, 180.0);
            }
        });
    }
    
    // Beverages
    private void waterButton(){
        btnWater.setText("Water");
        btnWater.setToolTipText("Water");
        btnWater.setPreferredSize(new Dimension(170, 50));
        btnWater.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblBeverageMenuLine(btnWater, 15.0);
            }
        });
    }

    private void pepsiButton(){
        btnPepsi.setText("Pepsi");
        btnPepsi.setToolTipText("Pepsi");
        btnPepsi.setPreferredSize(new Dimension(170, 50));
        btnPepsi.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblBeverageMenuLine(btnPepsi, 25.0);
            }
        });
    }

    private void spriteButton(){
        btnSprite.setText("Sprite");
        btnSprite.setToolTipText("Sprite");
        btnSprite.setPreferredSize(new Dimension(170, 50));
        btnSprite.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblBeverageMenuLine(btnSprite, 25.0);
            }
        });
    }

    private void fantaButton(){
        btnFanta.setText("Fanta");
        btnFanta.setToolTipText("Fanta");
        btnFanta.setPreferredSize(new Dimension(170, 50));
        btnFanta.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblBeverageMenuLine(btnFanta, 25.0);
            }
        });
    }

    private void sodaButton(){
        btnSoda.setText("Soda");
        btnSoda.setToolTipText("Soda");
        btnSoda.setPreferredSize(new Dimension(170, 50));
        btnSoda.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblBeverageMenuLine(btnSoda, 25.0);
            }
        });
    }

    private void greenTeaButton(){
        btnGreenTea.setText("Green Tea");
        btnGreenTea.setToolTipText("Green Tea");
        btnGreenTea.setPreferredSize(new Dimension(170, 50));
        btnGreenTea.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addtblBeverageMenuLine(btnGreenTea, 35.0);
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
