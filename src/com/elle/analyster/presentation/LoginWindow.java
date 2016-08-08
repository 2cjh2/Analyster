/**
 * @author Louis W.
 * @author Carlos Igreja
 * @since June 10, 2015
 * @version 0.6.3
 */
package com.elle.analyster.presentation;

import static com.elle.analyster.presentation.AnalysterWindow.version;
import com.elle.analyster.database.DBConnection;
import com.elle.analyster.admissions.Authorization;
import com.elle.analyster.controller.DataManager;
import com.elle.analyster.database.Database;
import com.elle.analyster.database.Server;
import com.elle.analyster.logic.LoggingAspect;
import static com.elle.analyster.presentation.LogWindow.HYPHENS;
import java.awt.Font;
import java.awt.FontMetrics;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginWindow extends JFrame {

    // class attributes 
    private String selectedServer;              // selected server
    private String selectedDB;                  // selected database
    private String userName;                    // user name to login 
    private String userPassword;                // user password to login

    // class component instances
    private AnalysterWindow analyster;
    private EditDatabaseWindow editDatabaseList;
    private LogWindow logWindow;
    private ArrayList<Server> servers;
    
    public LoginWindow() throws Exception {
    
        initComponents();
        this.setTitle();
        loadServers();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jInputPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxServer = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        passwordFieldPW = new javax.swing.JPasswordField();
        textFieldUsername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboBoxDatabase = new javax.swing.JComboBox();
        jButtonPanel = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        btnEditDB = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(475, 325));
        setMinimumSize(new java.awt.Dimension(475, 325));
        setPreferredSize(new java.awt.Dimension(475, 325));
        setSize(new java.awt.Dimension(475, 325));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jInputPanel.setMinimumSize(new java.awt.Dimension(475, 325));
        jInputPanel.setPreferredSize(new java.awt.Dimension(475, 325));
        jInputPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html><b>Please input your username and password to log in.</b></html>");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setMaximumSize(new java.awt.Dimension(400, 17));
        jLabel1.setMinimumSize(new java.awt.Dimension(400, 17));
        jLabel1.setPreferredSize(new java.awt.Dimension(400, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jInputPanel.add(jLabel1, gridBagConstraints);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("<html><b>Server</b></html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 0, 0, 0);
        jInputPanel.add(jLabel4, gridBagConstraints);

        comboBoxServer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pupone", "Local" }));
        comboBoxServer.setMinimumSize(new java.awt.Dimension(6, 20));
        comboBoxServer.setPreferredSize(new java.awt.Dimension(6, 20));
        comboBoxServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxServerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 252;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        jInputPanel.add(comboBoxServer, gridBagConstraints);

        jLabel2.setText("<html><b>Username</b></html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 0, 0, 0);
        jInputPanel.add(jLabel2, gridBagConstraints);

        jLabel3.setText("<html><b>Password</b></html");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        jInputPanel.add(jLabel3, gridBagConstraints);

        passwordFieldPW.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        passwordFieldPW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldPWActionPerformed(evt);
            }
        });
        passwordFieldPW.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldPWKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 247;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 8, 0, 0);
        jInputPanel.add(passwordFieldPW, gridBagConstraints);

        textFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldUsernameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 247;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 8, 0, 0);
        jInputPanel.add(textFieldUsername, gridBagConstraints);

        jLabel5.setText("<html><b>Database</b></html");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 0, 0, 0);
        jInputPanel.add(jLabel5, gridBagConstraints);

        comboBoxDatabase.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "dummy", "Elle2015", "pupone_dummy", "pupone_Analyster" }));
        comboBoxDatabase.setMinimumSize(new java.awt.Dimension(6, 20));
        comboBoxDatabase.setPreferredSize(new java.awt.Dimension(6, 20));
        comboBoxDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxDatabaseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 252;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 10, 0, 0);
        jInputPanel.add(comboBoxDatabase, gridBagConstraints);

        jButtonPanel.setLayout(new java.awt.GridBagLayout());

        btnCancel.setText("Cancel/ Log off");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 2);
        jButtonPanel.add(btnCancel, gridBagConstraints);

        btnLogin.setText("Log in");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 57;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 0);
        jButtonPanel.add(btnLogin, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 0);
        jInputPanel.add(jButtonPanel, gridBagConstraints);

        btnEditDB.setText("Edit");
        btnEditDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDBActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 0);
        jInputPanel.add(btnEditDB, gridBagConstraints);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel6.setMaximumSize(new java.awt.Dimension(250, 21));
        jLabel6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 260;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 30, 0);
        jInputPanel.add(jLabel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 11, 0);
        getContentPane().add(jInputPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.close();

    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * Close down application properly
     */
    public void close() {

        // terminate window and return resources
        this.dispose();
        System.exit(0); // Terminates the currently running Java Virtual Machine.
    }
    private void btnLoginActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        try {
            login();
        } catch (Exception ex) {
            Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void passwordFieldPWKeyPressed(KeyEvent evt) {//GEN-FIRST:event_passwordFieldPWKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            try {
                login();
            } catch (Exception ex) {
                Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }//GEN-LAST:event_passwordFieldPWKeyPressed

    private void comboBoxDatabaseActionPerformed(ActionEvent evt) {//GEN-FIRST:event_comboBoxDatabaseActionPerformed

        updateSelection();
    }//GEN-LAST:event_comboBoxDatabaseActionPerformed

    private void comboBoxServerActionPerformed(ActionEvent evt) {//GEN-FIRST:event_comboBoxServerActionPerformed

        updateSelection();
    }//GEN-LAST:event_comboBoxServerActionPerformed

    private void btnEditDBActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnEditDBActionPerformed

        try {
        // create a new edit selectedDB window
        editDatabaseList = new EditDatabaseWindow(this); // maybe we can make it not dependant on this
        } catch (Exception ex) {
            Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        editDatabaseList.setLocationRelativeTo(this);
        editDatabaseList.setVisible(true);
    }//GEN-LAST:event_btnEditDBActionPerformed

    private void textFieldUsernameActionPerformed(ActionEvent evt) {//GEN-FIRST:event_textFieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldUsernameActionPerformed

    private void passwordFieldPWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldPWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldPWActionPerformed
    public String getUserName() {
        // local host testing or if does not contain pupone
        if(userName.startsWith("pupone")){
            String userNameToAL = userName.substring(7);
            return userNameToAL;
        }
        else{
            return userName;
    }
    }

    /**
     * login
     */
    public void login() throws Exception {

        // get user data
        selectedServer = comboBoxServer.getSelectedItem().toString();
        selectedDB = comboBoxDatabase.getSelectedItem().toString();
        userName = textFieldUsername.getText();
        char[] pw = passwordFieldPW.getPassword();
        userPassword = String.valueOf(pw);
        
        // logwindow
        logWindow = new LogWindow(); 
        logWindow.setUserLogFileDir(this.getUserName());
        // write to log file
        String date = logWindow.dateFormat.format(new Date());
        logWindow.addMessage(HYPHENS + date + HYPHENS);
        logWindow.readMessages(); // read log messages from the log file
        
        // connect to database
        logWindow.addMessageWithDate("Connecting to the server...");
         jLabel6.setText("<html><b>Connecting to the server...</b></html>");
        jLabel6.paintImmediately(jLabel6.getVisibleRect());

        if (DBConnection.connect(selectedServer, selectedDB, userName, userPassword)) {
            logWindow.addMessageWithDate("Connect successfully!");
            
            jLabel6.setText("<html><b>Connection successful!<br>Authenticating...</b></html>");
           jLabel6.paintImmediately(jLabel6.getVisibleRect());
          
           logWindow.addMessageWithDate("Authenticating...");
            
            
            if(!Authorization.getInfoFromDB()){
                logWindow.addMessageWithDate("This user has not been authorized!"
                                          + "\n Access denied!");
                
                jLabel6.setText("This user has not been authorized!"
                                          + "\n Access denied!");
                jLabel6.paintImmediately(jLabel6.getVisibleRect());
                JOptionPane.showMessageDialog(this, "You have not been authorized. Default user access.");
                JOptionPane.showMessageDialog(this, "Logged in as default user.");
            }
            
            userName = userName.substring(7);
             System.out.println("userName: " + userName);
            logWindow.addMessageWithDate("Authenticating...");
            logWindow.addMessageWithDate("Authentication Successful!" + " Username: " + userName);
            
            jLabel6.setText("<html><b>Authentication complete!" + " Username: " + userName+ "<br> Loading tables...</b></html>");
            jLabel6.paintImmediately(jLabel6.getVisibleRect());
            
            
            // create an Analyster object
            DataManager dataManager = new DataManager();
            analyster = new AnalysterWindow();
            
           
            // pass the log window to analyster
            analyster.setLogWindow(logWindow);

            // pass the selectedDB to elle_gui
            // it is used in sql statements
            analyster.setDatabase(selectedDB);
            
            //pass the selectedServer to project Manager
            //used to show the server in the menubar
            analyster.setServer(selectedServer);

            // show the database and server names in menubar
            analyster.showDatabase();

            // show Analyster
            analyster.setLocationRelativeTo(this);
            analyster.setVisible(true);
            
            // terminate this object
            this.dispose(); // returns used resources
            
            
        } else {

            JOptionPane.showMessageDialog(this,
                    "There was an error.\n Please try again or contact support if you need further assistance.",
                    "Error Message",
                   JOptionPane.ERROR_MESSAGE);
       
            passwordFieldPW.setText("");
        }
    }
            
    public String getSelectedServer() {
        return selectedServer;
    }
           
    public void setSelectedServer(String selectedServer) {
        this.selectedServer = selectedServer;
    }

    public String getSelectedDB() {
        return selectedDB;
    }

    public void setSelectedDB(String selectedDB) {
        this.selectedDB = selectedDB;
    }

    public String getUserPassword() {
        return userPassword;
    }
            
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
            
    public AnalysterWindow getAnalyster() {
        return analyster;
    }

    public void setAnalyster(AnalysterWindow analyster) {
        this.analyster = analyster;
    }
            
    public EditDatabaseWindow getEditDatabaseList() {
        return editDatabaseList;
    }
            
    public void setEditDatabaseList(EditDatabaseWindow editDatabaseList) {
        this.editDatabaseList = editDatabaseList;
       }
       
    public LogWindow getLogWindow() {
        return logWindow;
    }

    public void setLogWindow(LogWindow logWindow) {
        this.logWindow = logWindow;
    }
    
    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public JButton getBtnEditDB() {
        return btnEditDB;
    }

    public void setBtnEditDB(JButton btnEditDB) {
        this.btnEditDB = btnEditDB;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public void setBtnLogin(JButton btnLogin) {
        this.btnLogin = btnLogin;
    }

    public JComboBox getComboBoxDatabase() {
        return comboBoxDatabase;
    }

    public void setComboBoxDatabase(JComboBox comboBoxDatabase) {
        this.comboBoxDatabase = comboBoxDatabase;
    }

    public JComboBox getComboBoxServer() {
        return comboBoxServer;
    }

    public void setComboBoxServer(JComboBox comboBoxServer) {
        this.comboBoxServer = comboBoxServer;
    }

    public JPanel getjButtonPanel() {
        return jButtonPanel;
    }

    public void setjButtonPanel(JPanel jButtonPanel) {
        this.jButtonPanel = jButtonPanel;
    }

    public JPanel getjInputPanel() {
        return jInputPanel;
    }

    public void setjInputPanel(JPanel jInputPanel) {
        this.jInputPanel = jInputPanel;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

  
    public JPasswordField getPasswordFieldPW() {
        return passwordFieldPW;
    }

    public void setPasswordFieldPW(JPasswordField passwordFieldPW) {
        this.passwordFieldPW = passwordFieldPW;
    }

    public JTextField getTextFieldUsername() {
        return textFieldUsername;
    }

    public void setTextFieldUsername(JTextField textFieldUsername) {
        this.textFieldUsername = textFieldUsername;
    }
    
    private DefaultComboBoxModel getServersCBModel() {
        Vector serverNames = new Vector();
        for(Server server: servers){
            serverNames.addElement(server.getName());
        }
        if(serverNames.isEmpty()){
            serverNames.addElement("");
        }
        return new DefaultComboBoxModel(serverNames);
    }

    private DefaultComboBoxModel getDatabasesCBModel(String serverName) {
        Vector databases = new Vector();
        for(Server server: servers){
            if(server.getName().equals(serverName)){
                for(Database db: server.getDatabases()){
                    databases.addElement(db.getName());
                }
            }
        }
        if(databases.isEmpty()){
            databases.addElement("");
        }
        return new DefaultComboBoxModel(databases);
    }
    
    public void loadServers() throws Exception {
        servers = DBConnection.readServers();
        // set comboboxes for servers and databases
        comboBoxServer.setModel(getServersCBModel());
        comboBoxDatabase.setModel(getDatabasesCBModel(servers.get(0).getName()));
        comboBoxServer.setSelectedIndex(getDefaultServer());
        int server = comboBoxServer.getSelectedIndex();
        int defaultDbIndex = getDefaultDatabase(server);
        Database db = servers.get(server).getDatabases().get(defaultDbIndex);
        comboBoxDatabase.setSelectedIndex(defaultDbIndex);
        textFieldUsername.setText(db.getUsername());
        passwordFieldPW.setText(db.getPassword());
    }
    
    private int getDefaultServer() {
        int server = 0;
        for(int i = 0; i < servers.size(); i++){
            if(servers.get(i).isDefaultSelection()){
                server = i;
                break;
            }
        }
        return server;
    }

    private int getDefaultDatabase(int server) {
        int database = 0;
        ArrayList<Database> databases = servers.get(server).getDatabases();
        for(int i = 0; i < databases.size(); i++){
            if(databases.get(i).isDefaultSelection()){
                database = i;
                break;
            }
        }
        return database;
    }

    /*Corinne 7/11/16
    //calculate the left spacing needed to center the title, 
     create a formatted string which contains this space, and add the formatted string(spacing) to the title*/
    private void setTitle(){
        Font f = this.getFont();
        FontMetrics fm = this.getFontMetrics(f);
        String title = "Log in to Analyster " + version;
        
        /*calculate the left spacing needed to center the title
        This may not return an accurate value. Adjust the amount 
        subtracted from z/y to obtain a more accurate value.*/
        int x = fm.stringWidth(title);
        int y = fm.stringWidth(" ");
        int z = this.getWidth()/2 - (x/2);
        int w = z/y - 12; //subtract to from z/y to position the string closer to the center
        String pad ="";
        pad = String.format("%"+w+"s", pad);
        this.setTitle(pad+title);
    }
/**
     * used to update the selection when a combobox is changed
     */
    private void updateSelection() {
        String selectedServer;
        selectedServer = comboBoxServer.getSelectedItem().toString();
        comboBoxDatabase.setModel(getDatabasesCBModel(selectedServer));
        int server = comboBoxServer.getSelectedIndex();
        int dbIndex = getDefaultDatabase(server);
        comboBoxDatabase.setSelectedIndex(dbIndex);
        Database db = servers.get(server).getDatabases().get(dbIndex);
        textFieldUsername.setText(db.getUsername());
        passwordFieldPW.setText(db.getPassword());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEditDB;
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox comboBoxDatabase;
    private javax.swing.JComboBox comboBoxServer;
    private javax.swing.JPanel jButtonPanel;
    private javax.swing.JPanel jInputPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField passwordFieldPW;
    private javax.swing.JTextField textFieldUsername;
    // End of variables declaration//GEN-END:variables

}
