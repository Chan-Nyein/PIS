
package java_program;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


public class LogIn extends javax.swing.JFrame {
    String u1="admin",p1="admin";
    String u2="user",p2="user";
    /** Creates new form LogIn */
    public LogIn() {
        initComponents();
        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension d=tk.getScreenSize();
        setLocation((d.width-getSize().width)/2,(d.height-getSize().height)/2);
    }
    private String check_account(){
        String u=jtxtusername.getText();
        String p=String.copyValueOf(jpassword.getPassword());
        if(u.contentEquals(u1)&&p.contentEquals(p1)){
            return "admin";
        }
        else if(u.contentEquals(u2)&&p.contentEquals(p2)){
            return "user";
        }
        else return "wrong";
    }
    private void load_account(){
        String s=check_account();
        if(s.contentEquals("admin")||s.contentEquals("user")){
            PlayerInformation pi=new PlayerInformation();
            pi.set_User(s);
            pi.setVisible(true);
            setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(this,"Invalid User Name and Password","Wrong User Name and Password",JOptionPane.ERROR_MESSAGE);
            jtxtusername.selectAll();
            jtxtusername.requestFocus();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtusername = new javax.swing.JTextField();
        jbtnok = new javax.swing.JButton();
        jbtncancel = new javax.swing.JButton();
        jpassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lon In");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1.setText("User Name");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel2.setText("Password");

        jbtnok.setMnemonic('O');
        jbtnok.setText("OK");
        jbtnok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnokActionPerformed(evt);
            }
        });

        jbtncancel.setMnemonic('C');
        jbtncancel.setText("Cancel");
        jbtncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtncancelActionPerformed(evt);
            }
        });

        jpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpasswordKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jtxtusername, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addGap(48, 48, 48))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jbtnok)
                .addGap(11, 11, 11)
                .addComponent(jbtncancel))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(jtxtusername)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnok)
                    .addComponent(jbtncancel))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpasswordKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
    load_account();
}//GEN-LAST:event_jpasswordKeyPressed

private void jbtnokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnokActionPerformed
load_account();
}//GEN-LAST:event_jbtnokActionPerformed

private void jbtncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtncancelActionPerformed
System.exit(0);
}//GEN-LAST:event_jbtncancelActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtncancel;
    private javax.swing.JButton jbtnok;
    private javax.swing.JPasswordField jpassword;
    private javax.swing.JTextField jtxtusername;
    // End of variables declaration//GEN-END:variables

}
