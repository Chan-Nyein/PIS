

package java_program;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PlayerInformation extends javax.swing.JFrame {
    //Variable declaration
    private String user=null;
    private char new_edit;
    private ArrayList alread=new ArrayList();
    private ArrayList alsearch=new ArrayList();
    private ArrayList sdata=new ArrayList();
    private Stack st1=new Stack();
    private Stack st2=new Stack();
    private int data_index;
    private BufferedImage bi;
    private File imagefilepath=null;
    private String id,name,dob,co,des;
    /** Creates new form PlayerInformation */
    public PlayerInformation() {
        initComponents();
        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension d=tk.getScreenSize();
        setLocation((d.width-getSize().width)/2,(d.height-getSize().height)/2);
        read_File();
        component_Enable("Load");
        jButtonNext.setEnabled(false);
        jButtonLast.setEnabled(false);
        jTextFieldSearch.setVisible(false);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                quit();
            }
        });
    }

    public void set_User(String s){
        user=s;
    }
    //Show or hide menu item method
    private void menuitem_Enable(String s){
        if(s.contentEquals("Load")||s.contentEquals("Save")||s.contentEquals("Cancel")||s.contentEquals("Delete")){
            jMenuItemNew.setEnabled(true);
            jMenuItemSave.setEnabled(false);
            jMenuItemEdit.setEnabled(false);
            jMenuItemDel.setEnabled(false);
        }
        else if(s.contentEquals("New")||s.contentEquals("Edit")){
            jMenuItemNew.setEnabled(false);
            jMenuItemSave.setEnabled(true);
            jMenuItemEdit.setEnabled(false);
            jMenuItemDel.setEnabled(false);
        }
        else if(s.contentEquals("Find")){
            jMenuItemNew.setEnabled(true);
            jMenuItemSave.setEnabled(false);
            jMenuItemEdit.setEnabled(true);
            jMenuItemDel.setEnabled(true);
        }
    }
//Show or hide program components method
private void component_Display(char c){
    switch(c){
        case'T':{
           jTextFieldID.setEnabled(true);
           jTextFieldName.setEnabled(true);
           jTextFieldDOB.setEnabled(true);
           jTextFieldCo.setEnabled(true);
           jTextAreaDes.setEnabled(true);
           jButtonClear.setEnabled(true);
           jButtonPhoto.setEnabled(true);
        };break;
        case'F':{
           jTextFieldID.setEnabled(false);
           jTextFieldName.setEnabled(false);
           jTextFieldDOB.setEnabled(false);
           jTextFieldCo.setEnabled(false);
           jTextAreaDes.setEnabled(false);
           jButtonClear.setEnabled(false);
           jButtonPhoto.setEnabled(false);
        };break;
        case 'E':{
           jTextFieldID.setEnabled(false);
           jTextFieldName.setEnabled(true);
           jTextFieldDOB.setEnabled(true);
           jTextFieldCo.setEnabled(true);
           jTextAreaDes.setEnabled(true);
           jButtonClear.setEnabled(true);
           jButtonPhoto.setEnabled(true);
        }
    }
}
//Show or hide program components method
private void component_Other(char c){
   switch(c){
       case'T':{
            jRadioButtonPID.setEnabled(true);
            jRadioButtonPN.setEnabled(true);
            jRadioButtonPoPN.setEnabled(true);
            jTextFieldSearch.setEnabled(true);
            jListFPN.setEnabled(true);
            jButtonSearch.setEnabled(true);
            jButtonShow.setEnabled(true);
            jButtonSClear.setEnabled(true);
       };break;
       case'F':{
            jRadioButtonPID.setEnabled(false);
            jRadioButtonPN.setEnabled(false);
            jRadioButtonPoPN.setEnabled(false);
            jTextFieldSearch.setEnabled(false);
            jListFPN.setEnabled(false);
            jButtonSearch.setEnabled(false);
            jButtonShow.setEnabled(false);
            jButtonSClear.setEnabled(false);
       };
   }
   }
//Show or hide program components method
private void component_Botton_1(char c){
    switch(c){
        case'T':{
            jCheckBoxFound.setEnabled(true);
            jButtonPBack.setEnabled(true);
            jButtonPNext.setEnabled(true);
        };break;
        case'F':{
            jCheckBoxFound.setEnabled(false);
            jButtonPBack.setEnabled(false);
            jButtonPNext.setEnabled(false);
        };break;
        case'O':{
            jCheckBoxFound.setEnabled(true);
            jButtonPBack.setEnabled(false);
            jButtonPNext.setEnabled(false);
        };       
        }
    }
//Show or hide program components method
private void component_button_2(char c){
        switch(c){
            case'F':{
                jCheckBoxAll.setEnabled(false);
                jButtonFirst.setEnabled(false);
                jButtonLast.setEnabled(false);
                jButtonNext.setEnabled(false);
                jButtonPre.setEnabled(false);
            };break;
            case 'L':{
                jCheckBoxAll.setEnabled(true);
                jButtonFirst.setEnabled(false);
                jButtonLast.setEnabled(false);
                jButtonNext.setEnabled(false);
                jButtonPre.setEnabled(false);
            }
            case 'O':{
                jCheckBoxAll.setEnabled(true);
                jButtonFirst.setEnabled(false);
                jButtonLast.setEnabled(true);
                jButtonNext.setEnabled(true);
                jButtonPre.setEnabled(false);
            }
        }   
   }
//Setting for show or hide program components method
private void component_Enable(String s){
       if(s.contentEquals("Load")||s.contentEquals("Save")||s.contentEquals("Cancel")||s.contentEquals("Delete")){
               menuitem_Enable("Load");
               component_Display('F');
               component_Other('T');
               component_Botton_1('O');
               component_button_2('L');
           }
        else if(s.contentEquals("New")||s.contentEquals("Edit")){
               menuitem_Enable("New");
               if(s.contentEquals("New"))component_Display('T');
               else component_Display('E');
               component_Other('F');
               component_Botton_1('O');
               component_button_2('F');
           }
         else if(s.contentEquals("All")){
               menuitem_Enable("Find");
               component_Display('F');
               component_Other('F');
               component_Botton_1('O');
               component_button_2('O');
           }
           else if(s.contentEquals("Search")){
               menuitem_Enable("Find");
               component_Display('F');
               component_Other('F');
               component_Botton_1('O');
               component_button_2('F');
           }
}
private void set_Data(int i){
    data_index=i;
    StringTokenizer st=new StringTokenizer(alread.get(i).toString(),"\t");
    while(st.hasMoreTokens()){
        jTextFieldID.setText(st.nextToken());
        jTextFieldName.setText(st.nextToken());
        jTextFieldDOB.setText(st.nextToken());
        jTextFieldCo.setText(st.nextToken());
        jTextAreaDes.setText(st.nextToken());
        imagefilepath=new File("Data/image/"+st.nextToken());
        imagefilepath=new File(imagefilepath.getAbsolutePath());
        try{
            bi=ImageIO.read(imagefilepath);
            jLabelPhoto.setIcon(new ImageIcon(resize(bi)));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
private void get_Data(){
    id=jTextFieldID.getText().trim();
    name=jTextFieldName.getText().trim();
    dob=jTextFieldDOB.getText().trim();
    co=jTextFieldCo.getText().trim();
    des=jTextAreaDes.getText().trim();
}
private void clear_Data(char c){
    if(c=='D'){
        jTextFieldID.setText("");
        jTextFieldName.setText("");
        jTextFieldDOB.setText("");
        jTextFieldCo.setText("");
        jTextAreaDes.setText("");
        jLabelPhoto.setIcon(null);
        imagefilepath=null;
    }
    else{
        jTextFieldSearch.setText("");
        sdata.clear();
        jListFPN.setListData(sdata.toArray());
    }
}
//Checking data method
private boolean data_Check(){
    boolean b=false;
    if(id.isEmpty()){
        JOptionPane.showMessageDialog(this,"You Must Enter ID!","NO ID",JOptionPane.WARNING_MESSAGE);
        jTextFieldID.requestFocus();
    }
    else if(name.isEmpty()){
        JOptionPane.showMessageDialog(this,"YOU Must Enter Name!","No Name",JOptionPane.WARNING_MESSAGE);
        jTextFieldName.requestFocus();
    }
    else if(dob.isEmpty()){
        JOptionPane.showMessageDialog(this,"YOU Must Enter Date of Birth!","No Date of Birth",JOptionPane.WARNING_MESSAGE);
        jTextFieldDOB.requestFocus();
    }
    else if(des.isEmpty()){
        JOptionPane.showMessageDialog(this, "YOu Must Enter Description for player!","NO Description",JOptionPane.WARNING_MESSAGE);
        jTextAreaDes.requestFocus();
    }
    else if(imagefilepath==null){
        JOptionPane.showMessageDialog(this, "You Must load Player Image!","No Image",JOptionPane.WARNING_MESSAGE);
        jButtonPhoto.requestFocus();
    }
    else b=true;
    return b;
}
//Reading data file method
private void read_File(){
    try{
        File f=new File("Data/data.txt");
        FileReader fr=new FileReader(f.getAbsolutePath());
        BufferedReader br=new BufferedReader(fr);
        String str;
        alread.clear();
        while((str=br.readLine())!=null){
            alread.add(str);
        }
        br.close();
    }
    catch(IOException e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }    
}
//Resize the image method
private BufferedImage resize(BufferedImage img){
        int w=img.getWidth();
        int h=img.getHeight();
        BufferedImage dimg=new BufferedImage(jLabelPhoto.getWidth(),jLabelPhoto.getHeight(),img.getType());
        Graphics2D g=dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img,0,0,jLabelPhoto.getWidth(),jLabelPhoto.getHeight(),0,0,w,h,null);
        g.dispose();
        return dimg;
    }
//Writing data file method
private void write_Data(){
    try{
        File f=new File("Data/data.txt");
        FileWriter fw=new FileWriter(f.getAbsolutePath());
        PrintWriter pw=new PrintWriter(fw);
        for(int i=0;i<alread.size();i++)
            pw.println(alread.get(i));
        pw.close();
    }
    catch(IOException ie){
        JOptionPane.showMessageDialog(null, ie.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
    }
}
//Writing data image method
private void write_Image(BufferedImage bi,File f){
    try{
        f=new File(f.getAbsolutePath());
        ImageIO.write(bi, "jpg", f);
        clear_Data('D');
        jTextFieldID.requestFocus();
    }
    catch(IOException ie){
        JOptionPane.showMessageDialog(null, ie.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
    }
}
//Searching method
private ArrayList search(String s,String type){
    ArrayList altemp=new ArrayList();
    if(type.contentEquals("Number")){
        String str;
        if(!alread.isEmpty()){
            for(int i=0;i<alread.size();i++){
                StringTokenizer st=new StringTokenizer(alread.get(i).toString(),"\t");
                str=st.nextToken();
                if(str.contentEquals(s)){
                    alsearch.add(i);
                    altemp.add(i);
                    break;
                }
            }
        }
    }
    else{
        String str;
        if(!alread.isEmpty()){
            sdata.clear();
            for(int i=0;i<alread.size();i++){
                StringTokenizer st=new StringTokenizer(alread.get(i).toString(),"\t");
                st.nextToken();
                str=st.nextToken();
                if(type.contentEquals("Name")){
                    if(str.contentEquals(s)){
                        alsearch.add(i);
                        altemp.add(i);
                        break;
                    }
                }
                else{
                    if(str.contains(s)){
                    altemp.add(i);
                    sdata.add(str);
                }
            }
        }
    }
    }
        return altemp;

}
//Quit program method
private void quit(){
        try {
            int ask=JOptionPane.showConfirmDialog(this,"ARE YOU SURE?","Exit",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(ask==JOptionPane.OK_OPTION)
                    System.exit(0);
                else if(ask==JOptionPane.CANCEL_OPTION)
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
        catch(Exception e){}
    }    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDOB = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDes = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabelPhoto = new javax.swing.JLabel();
        jButtonPhoto = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jCheckBoxAll = new javax.swing.JCheckBox();
        jButtonFirst = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jButtonPre = new javax.swing.JButton();
        jButtonLast = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jRadioButtonPID = new javax.swing.JRadioButton();
        jRadioButtonPN = new javax.swing.JRadioButton();
        jRadioButtonPoPN = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListFPN = new javax.swing.JList();
        jButtonSearch = new javax.swing.JButton();
        jButtonShow = new javax.swing.JButton();
        jButtonSClear = new javax.swing.JButton();
        jLabelName = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jCheckBoxFound = new javax.swing.JCheckBox();
        jButtonPNext = new javax.swing.JButton();
        jButtonPBack = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemNew = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemEdit = new javax.swing.JMenuItem();
        jMenuItemDel = new javax.swing.JMenuItem();
        jMenuItemCancel = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuItemChangeLogIn = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Player Information System");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 102)), "Player Detail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Player ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jTextFieldID.setDisabledTextColor(new java.awt.Color(0, 0, 153));
        jPanel1.add(jTextFieldID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 150, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jTextFieldDOB.setDisabledTextColor(new java.awt.Color(0, 0, 153));
        jPanel1.add(jTextFieldDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 150, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Date of Birth");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jTextFieldName.setDisabledTextColor(new java.awt.Color(0, 0, 153));
        jPanel1.add(jTextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 150, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Country");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jTextFieldCo.setDisabledTextColor(new java.awt.Color(0, 0, 153));
        jPanel1.add(jTextFieldCo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 150, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Description");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jTextAreaDes.setColumns(20);
        jTextAreaDes.setLineWrap(true);
        jTextAreaDes.setRows(5);
        jTextAreaDes.setWrapStyleWord(true);
        jTextAreaDes.setDisabledTextColor(new java.awt.Color(0, 0, 153));
        jScrollPane1.setViewportView(jTextAreaDes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 270, 170));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Photo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabelPhoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabelPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 150, 120));

        jButtonPhoto.setMnemonic('P');
        jButtonPhoto.setText("Photo");
        jButtonPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPhotoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, -1, -1));

        jButtonClear.setMnemonic('C');
        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 290));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 102)), "All Player", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 14))); // NOI18N

        jCheckBoxAll.setBackground(new java.awt.Color(0, 204, 204));
        jCheckBoxAll.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxAll.setText("All Player");
        jCheckBoxAll.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxAllItemStateChanged(evt);
            }
        });

        jButtonFirst.setMnemonic('F');
        jButtonFirst.setText("First");
        jButtonFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFirstActionPerformed(evt);
            }
        });

        jButtonNext.setMnemonic('N');
        jButtonNext.setText("Next");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jButtonPre.setMnemonic('P');
        jButtonPre.setText("Previous");
        jButtonPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreActionPerformed(evt);
            }
        });

        jButtonLast.setMnemonic('L');
        jButtonLast.setText("Last");
        jButtonLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonFirst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonLast, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jButtonNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonPre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jCheckBoxAll, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBoxAll)
                .addGap(27, 27, 27)
                .addComponent(jButtonFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButtonPre)
                .addGap(18, 18, 18)
                .addComponent(jButtonNext)
                .addGap(28, 28, 28)
                .addComponent(jButtonLast)
                .addGap(32, 32, 32))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 200, 290));

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)), "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 14))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioButtonPID.setBackground(new java.awt.Color(0, 204, 204));
        buttonGroup1.add(jRadioButtonPID);
        jRadioButtonPID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonPID.setText("Search by Player ID");
        jRadioButtonPID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonPIDItemStateChanged(evt);
            }
        });
        jPanel3.add(jRadioButtonPID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jRadioButtonPN.setBackground(new java.awt.Color(0, 204, 204));
        buttonGroup1.add(jRadioButtonPN);
        jRadioButtonPN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonPN.setText("Search by Player Name");
        jRadioButtonPN.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonPNItemStateChanged(evt);
            }
        });
        jPanel3.add(jRadioButtonPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jRadioButtonPoPN.setBackground(new java.awt.Color(0, 204, 204));
        buttonGroup1.add(jRadioButtonPoPN);
        jRadioButtonPoPN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonPoPN.setText("Search by Part of Player Name");
        jRadioButtonPoPN.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonPoPNItemStateChanged(evt);
            }
        });
        jPanel3.add(jRadioButtonPoPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Found Player Name");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        jScrollPane2.setViewportView(jListFPN);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 210, 90));

        jButtonSearch.setMnemonic('S');
        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        jButtonShow.setMnemonic('h');
        jButtonShow.setText("Show");
        jButtonShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        jButtonSClear.setMnemonic('C');
        jButtonSClear.setText("Clear");
        jButtonSClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSClearActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonSClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, -1, -1));

        jLabelName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelName.setText("Player Identification Number");
        jPanel3.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        jPanel3.add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 490, 220));

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)), "Previous Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 14))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxFound.setBackground(new java.awt.Color(0, 204, 204));
        jCheckBoxFound.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxFound.setText("Found Player");
        jCheckBoxFound.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxFoundItemStateChanged(evt);
            }
        });
        jPanel4.add(jCheckBoxFound, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jButtonPNext.setMnemonic('e');
        jButtonPNext.setText("Next");
        jButtonPNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPNextActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonPNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));

        jButtonPBack.setMnemonic('B');
        jButtonPBack.setText("Back");
        jButtonPBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPBackActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonPBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 270, 220));

        jMenu1.setText("File");

        jMenuItemNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemNew.setText("New");
        jMenuItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNewActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemNew);

        jMenuItemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSave.setText("Save");
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSave);

        jMenuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemExit.setText("Exit");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItemEdit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemEdit.setText("Edit");
        jMenuItemEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemEdit);

        jMenuItemDel.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemDel.setText("Delete");
        jMenuItemDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDelActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemDel);

        jMenuItemCancel.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemCancel.setText("Cancel");
        jMenuItemCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCancelActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemCancel);
        jMenu2.add(jSeparator1);

        jMenuItemChangeLogIn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemChangeLogIn.setText("Change Log In");
        jMenuItemChangeLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemChangeLogInActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemChangeLogIn);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
quit();
}//GEN-LAST:event_jMenuItemExitActionPerformed

private void jMenuItemNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNewActionPerformed
if(user.contentEquals("admin")){
    jCheckBoxAll.setSelected(false);
    jCheckBoxFound.setSelected(false);
    clear_Data('D');
    component_Enable("New");
    jTextFieldID.requestFocus();
    new_edit='N';
}
else{
    JOptionPane.showMessageDialog(this,"You hava not enough right to"+"do this action.","Access Denied",JOptionPane.WARNING_MESSAGE);
}
}//GEN-LAST:event_jMenuItemNewActionPerformed

private void jMenuItemChangeLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemChangeLogInActionPerformed
LogIn l=new LogIn();
l.setVisible(true);
setVisible(false);
}//GEN-LAST:event_jMenuItemChangeLogInActionPerformed

private void jMenuItemEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditActionPerformed
if(user.contentEquals("admin")){
    component_Enable("Edit");
    jTextFieldName.requestFocus();
    new_edit='E';
}
else{
    JOptionPane.showMessageDialog(this,"You have not enough right to"+"do this action.","Access Denied",JOptionPane.WARNING_MESSAGE);
}
}//GEN-LAST:event_jMenuItemEditActionPerformed

private void jButtonPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPhotoActionPerformed
JFileChooser jfc=new JFileChooser();
jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
jfc.setDialogTitle("Open Player Image");
jfc.setApproveButtonText("Load");
jfc.setApproveButtonMnemonic('L');
jfc.setAcceptAllFileFilterUsed(false);
jfc.addChoosableFileFilter(new FileNameExtensionFilter("JPEG Compressed Image Files (.jpg)","jpg"));
jfc.addChoosableFileFilter(new FileNameExtensionFilter("GIF Image Files (.gif)","gif"));
jfc.addChoosableFileFilter(new FileNameExtensionFilter("JPEG and GIF Image Files (.jpg,.gif)","jpg","gif"));
int value=jfc.showOpenDialog(this);
if(value==JFileChooser.APPROVE_OPTION){
    imagefilepath=jfc.getSelectedFile();
    try{
        bi=ImageIO.read(imagefilepath);
        jLabelPhoto.setIcon(new ImageIcon(resize(bi)));
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
    }
}
}//GEN-LAST:event_jButtonPhotoActionPerformed

private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
jLabelPhoto.setIcon(null);
imagefilepath=null;
}//GEN-LAST:event_jButtonClearActionPerformed

private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
get_Data();
if(data_Check()){
    File f=new File("Data/Image/"+id+".jpg");
    if(new_edit=='N'){
        if(!f.exists()){
            alread.add(id+"\t"+name+"\t"+dob+"\t"+co+"\t"+des+"\t"+f.getName());
            write_Data();
            write_Image(bi, f);
            jTextFieldID.requestFocus();
        }
        else{
            JOptionPane.showMessageDialog(null,"Player ID"+"duplication","Duplicat ID",JOptionPane.ERROR_MESSAGE);
            jTextFieldID.selectAll();
            jTextFieldID.requestFocus();
        }
    }
    else if(new_edit=='E'){
        alread.remove(data_index);
        alread.add(id+"\t"+name+"\t"+dob+"\t"+co+"\t"+des+"\t"+f.getName());
        Collections.sort(alread);
        write_Data();
        write_Image(bi, f);
        jTextFieldID.requestFocus();
    }
}
}//GEN-LAST:event_jMenuItemSaveActionPerformed

private void jButtonLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLastActionPerformed
st1.clear();
st2.clear();
for(int i=0;i<alread.size();i++)st2.push(i);
st1.push(st2.pop());
set_Data(Integer.parseInt(st1.peek().toString()));
jButtonLast.setEnabled(false);
jButtonPre.setEnabled(true);
jButtonFirst.setEnabled(true);
jButtonNext.setEnabled(false);
}//GEN-LAST:event_jButtonLastActionPerformed

private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
st2.push(st1.pop());
set_Data(Integer.parseInt(st1.peek().toString()));
if(st1.size()==1){
    jButtonLast.setEnabled(false);
    jButtonNext.setEnabled(false);
}
jButtonPre.setEnabled(true);
jButtonFirst.setEnabled(true);
}//GEN-LAST:event_jButtonNextActionPerformed

private void jButtonPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreActionPerformed
st1.push(st2.pop());
set_Data(Integer.parseInt(st1.peek().toString()));
if(st2.isEmpty()){
    jButtonFirst.setEnabled(false);
    jButtonPre.setEnabled(false);
}
jButtonNext.setEnabled(true);
jButtonLast.setEnabled(true);
}//GEN-LAST:event_jButtonPreActionPerformed

private void jButtonFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFirstActionPerformed
st1.clear();
st2.clear();
for(int i=alread.size()-1;i>=0;i--)st1.push(i);
set_Data(Integer.parseInt(st1.peek().toString()));
jButtonFirst.setEnabled(false);
jButtonNext.setEnabled(true);
jButtonLast.setEnabled(true);
jButtonPre.setEnabled(false);
}//GEN-LAST:event_jButtonFirstActionPerformed

private void jMenuItemDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDelActionPerformed
if(user.contentEquals("admin")){
    get_Data();
    int ask=JOptionPane.showConfirmDialog(this,"Are you sure to Delete"+"this player?","Delete",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    if(ask==JOptionPane.OK_OPTION){
        File f=new File("Data/Image/"+id+".jpg");
        f=new File(f.getAbsolutePath());
        alread.remove(id+"\t"+name+"\t"+dob+"\t"+co+"\t"+des+"\t"+f.getName());
        write_Data();
        if(f.exists())f.delete();
        component_Enable("New");
        clear_Data('D');
        jTextFieldID.requestFocus();
    }
}
else{
    JOptionPane.showMessageDialog(this,"You have not enough right to "+"do this action.","Access Denied",JOptionPane.WARNING_MESSAGE);
}
}//GEN-LAST:event_jMenuItemDelActionPerformed

private void jCheckBoxAllItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxAllItemStateChanged
if(jCheckBoxAll.isSelected()){
    clear_Data('S');
    if(jCheckBoxFound.isSelected())jCheckBoxFound.setSelected(false);
    component_Enable("All");
    st1.clear();
    st2.clear();
    if(!alread.isEmpty()){
        for(int i=alread.size()-1;i>=0;i--)st1.push(i);
        set_Data(Integer.parseInt(st1.peek().toString()));
    }
    else{
        JOptionPane.showMessageDialog(null,"No Data to View.","No Data",JOptionPane.INFORMATION_MESSAGE);
        jCheckBoxAll.setSelected(false);
        component_Enable("Load");
        jButtonNext.setEnabled(false);
        jButtonLast.setEnabled(false);
        if(jTextFieldSearch.isVisible())jTextFieldSearch.requestFocus();
    }
}
else{
    component_Enable("Load");
    clear_Data('D'); 
    jButtonNext.setEnabled(false);
    jButtonLast.setEnabled(false);
}                                         
}//GEN-LAST:event_jCheckBoxAllItemStateChanged

private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
String sch="";
clear_Data('D');
if(jTextFieldSearch.isVisible())sch=jTextFieldSearch.getText().trim();
if(!sch.isEmpty()){
    ArrayList al=new ArrayList();
    if(jRadioButtonPID.isSelected()){
        al=search(sch,"Number");
        if(al.isEmpty()){
            JOptionPane.showMessageDialog(this,"No match Data is found.","Not Found",JOptionPane.INFORMATION_MESSAGE);
            jTextFieldSearch.selectAll();
            jTextFieldSearch.requestFocus();
        }
        else{
            set_Data(Integer.parseInt(al.get(0).toString()));
        }
    }
    else if(jRadioButtonPN.isSelected()){
        al=search(sch,"Name");
        if(al.isEmpty()){
            JOptionPane.showMessageDialog(this,"No match Data is found.","Not Found",JOptionPane.INFORMATION_MESSAGE);
            jTextFieldSearch.selectAll();
            jTextFieldSearch.requestFocus();
        }
        else{
            set_Data(Integer.parseInt(al.get(0).toString()));
        }
    }
    else
        al=search(sch,"PName");
        if(al.isEmpty()){
            JOptionPane.showMessageDialog(this,"No match Data is found.","Not Found",JOptionPane.INFORMATION_MESSAGE);
            jTextFieldSearch.selectAll();
            jTextFieldSearch.requestFocus();
        }
        else{
            Collections.sort(al);
            jListFPN.setListData(sdata.toArray());
    }
}
else{
    JOptionPane.showMessageDialog(this,"You must enter the searched"+"word.","Empty Word",JOptionPane.WARNING_MESSAGE);
    if(jTextFieldSearch.isVisible())jTextFieldSearch.requestFocus();
}
}//GEN-LAST:event_jButtonSearchActionPerformed

private void jButtonShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowActionPerformed
if(!jListFPN.isSelectionEmpty()){
    ArrayList alt=new ArrayList();
    alt=search(jListFPN.getSelectedValue().toString(),"Name");
    set_Data(Integer.parseInt(alt.get(0).toString()));
}
else if(!sdata.isEmpty()){
    JOptionPane.showMessageDialog(this,"You must select the name in the"+"List.","Empty Selected Name",JOptionPane.WARNING_MESSAGE);    
}
}//GEN-LAST:event_jButtonShowActionPerformed

private void jButtonSClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSClearActionPerformed
clear_Data('S');
clear_Data('D');
}//GEN-LAST:event_jButtonSClearActionPerformed

private void jCheckBoxFoundItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxFoundItemStateChanged
if(alsearch.isEmpty() && jCheckBoxFound.isSelected()){
    jCheckBoxFound.setSelected(false);
    jCheckBoxAll.setSelected(false);
    jButtonNext.setEnabled(false);
    jButtonLast.setEnabled(false);
}
else if(jCheckBoxFound.isSelected()){
    jCheckBoxAll.setSelected(false);
    clear_Data('S');
    component_Enable("Search");
    
    if(alsearch.size()>1)jButtonPNext.setEnabled(true);
    st1.clear();
    st2.clear();
    for(int i=alsearch.size()-1;i>=0;i--) st1.push(alsearch.get(i));
    
    set_Data(Integer.parseInt(st1.peek().toString()));
}
else if(!jCheckBoxFound.isSelected()) {
    component_Enable("Load");
    clear_Data('D');
    jButtonNext.setEnabled(false);
    jButtonLast.setEnabled(false);
}
}//GEN-LAST:event_jCheckBoxFoundItemStateChanged

private void jButtonPBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPBackActionPerformed
st1.push(st2.pop());
set_Data(Integer.parseInt(st1.peek().toString()));
if(st2.isEmpty()){
    jButtonPBack.setEnabled(false);
}
jButtonPNext.setEnabled(true);
}//GEN-LAST:event_jButtonPBackActionPerformed

private void jButtonPNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPNextActionPerformed
st2.push(st1.pop());
set_Data(Integer.parseInt(st1.peek().toString()));
if(st1.size()==1){
    jButtonPNext.setEnabled(false);
}
jButtonPBack.setEnabled(true);
}//GEN-LAST:event_jButtonPNextActionPerformed

private void jRadioButtonPIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonPIDItemStateChanged
if(jRadioButtonPID.isSelected()){
    jLabelName.setText("Player Identification Number");
    jTextFieldSearch.setVisible(true);
}
jTextFieldSearch.setText("");
jTextFieldSearch.requestFocus();
}//GEN-LAST:event_jRadioButtonPIDItemStateChanged

private void jRadioButtonPNItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonPNItemStateChanged
if(jRadioButtonPN.isSelected()){
    jLabelName.setText("Player Name");
    jTextFieldSearch.setVisible(true);
}
jTextFieldSearch.setText("");
jTextFieldSearch.requestFocus();
}//GEN-LAST:event_jRadioButtonPNItemStateChanged

private void jRadioButtonPoPNItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonPoPNItemStateChanged
if(jRadioButtonPoPN.isSelected()){
    jLabelName.setText("Part of Player Name");
    jTextFieldSearch.setVisible(true);
}
jTextFieldSearch.setText("");
jTextFieldSearch.requestFocus();
}//GEN-LAST:event_jRadioButtonPoPNItemStateChanged

private void jMenuItemCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCancelActionPerformed
    clear_Data('D');
    component_Enable("Load");
     jButtonNext.setEnabled(false);
    jButtonLast.setEnabled(false);
    jCheckBoxAll.setSelected(false);
    
}//GEN-LAST:event_jMenuItemCancelActionPerformed
/**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayerInformation().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonFirst;
    private javax.swing.JButton jButtonLast;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPBack;
    private javax.swing.JButton jButtonPNext;
    private javax.swing.JButton jButtonPhoto;
    private javax.swing.JButton jButtonPre;
    private javax.swing.JButton jButtonSClear;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonShow;
    private javax.swing.JCheckBox jCheckBoxAll;
    private javax.swing.JCheckBox jCheckBoxFound;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelPhoto;
    private javax.swing.JList jListFPN;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemCancel;
    private javax.swing.JMenuItem jMenuItemChangeLogIn;
    private javax.swing.JMenuItem jMenuItemDel;
    private javax.swing.JMenuItem jMenuItemEdit;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemNew;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButtonPID;
    private javax.swing.JRadioButton jRadioButtonPN;
    private javax.swing.JRadioButton jRadioButtonPoPN;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextAreaDes;
    private javax.swing.JTextField jTextFieldCo;
    private javax.swing.JTextField jTextFieldDOB;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables

}
