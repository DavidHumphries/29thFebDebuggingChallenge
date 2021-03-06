package debuggingchallenge;

import java.text.DecimalFormat;

public class GUI extends javax.swing.JFrame {
   
    /* A total of 7 changes have been made 
    All changes made in the debugging task:
    REF 001 Changed Opperand1 & Opperand2 into double values. changed operartion to string
    REF 002 changed result into a double value.
    REF 003 Corrected Operation types 
    REF 004 Changed button 9 to be assigned to number 9
    REF 005 Changed button 1 to be assigned to number 1
    REF 006 reset line to empty string value
    REF 007 remove trailing 0
    */

    //Class variables
    
    
    // REF 001 Changed Opperand1 & Opperand2 into double values. changed operartion to string
    private double opperand1;
    private double opperand2;
    private String ans = "0";
    private String opperation;
    private boolean op1Set = false;
    private boolean op2Set = false;
    
    private String line = "";
    private boolean dotFlag = true;
    private String[] oppChars = {"/","*","-","+","^","% of","√"};
    private void addSumPart(String input){
        //If the first opperand has not been set
        if(!op1Set){
            //Determine if the character is an opperand
            boolean isInOppChars = false;
            for(String s : oppChars){
                if(s.equals(input)){
                    isInOppChars = true;
                }
            }
            if(isInOppChars){ // If it is
                //Get the value of the current line as the first opperand
                
                opperand1 = Double.valueOf(line);
               
                //opperand1 = Double.valueOf(line);
                op1Set = true;
                dotFlag = true;
                //Print out the opperation
                if (input.equals("^") || input.equals("√")){
                    this.outputBox.append(input);
                }else{
                    this.outputBox.append("\n" + input + "\n");
                }
                //this.outputBox.append("\n" + input + "\n");
                opperation = input;
                //Reset line
                line = "";
            } else { //If it's not
                //Add to line, and output
                line = line + input;
                this.outputBox.append(input);
            }   
        //If the user has inputted an equals
        } else if(input.equals("=")){
            //Print out a new line for the result
            this.outputBox.append("\n");
            opperand2 = Double.valueOf(line);
            op1Set = true;
            dotFlag = true;
            line = "";
            //Get the result and print it
            this.outputBox.append(this.doSum());
            reset();
        }
        else if(!op2Set){ //If opperand 2 is not set
            //Make sure the user hasn't put in a second opperand
            boolean isInOppChars = false;
            for(String s : oppChars){
                if(s.equals(input)){
                    isInOppChars = true;
                }
            }
            if(!isInOppChars){
                //Add the character to the line
                line = line + input;
                this.outputBox.append(input);
            }
        }
    }
    
    private String doSum(){
        //Get a result variable
        
        // REF 002 changed result into a double value.
        double result = 0;
        
        //Do the sums 
        
        // REF 003 Corrected Operation types  
 if(opperation.equals("*")){
            result = opperand1 * opperand2;
        } else if(opperation.equals("+")){
            result = opperand1 + opperand2;
        } else if(opperation.equals("/")){
            result = opperand1 / opperand2;
        } else if(opperation.equals("-")){
            result = opperand1 - opperand2;
        } else if(opperation.equals("^")){
            result = Math.pow(opperand1,opperand2);
        } else if(opperation.equals("% of")){
            result = (opperand1 / 100) * opperand2;
        } else if(opperation.equals("√")){
            result = opperand1 * Math.sqrt(opperand2);
        }
        //If something goes wrong
        else { 
            return "Error: Not a sum";
        } 



        //Return the double as a string
        
        
        // REF 007 remove trailing 0
        if (result % 1 == 0){
            DecimalFormat format = new DecimalFormat("0.#");
            ans = (format.format(result));
            return(format.format(result));
    
        }else{
        ans = Double.toString(result);
            return Double.toString(result);
        }
        //return Double.toString(result);
    }
    
    private void reset(){
        //Reset all the variables
        
        // REF 006 reset line to empty string value
        this.line = "";
        this.opperand1 = 0.0;
        this.opperand2 = 0.0;
        this.opperation = "";
        this.op1Set = false;
        this.op2Set = false;
    }
        
    public GUI() {
        //Initualise the components
        initComponents();
    }
    
    //This file has been modified by David Humphries
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HeaderLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputBox = new javax.swing.JTextArea();
        input7Button = new javax.swing.JButton();
        input8Button = new javax.swing.JButton();
        input9Button = new javax.swing.JButton();
        input4Button = new javax.swing.JButton();
        input5Button = new javax.swing.JButton();
        input6Button = new javax.swing.JButton();
        input1Button = new javax.swing.JButton();
        input2Button = new javax.swing.JButton();
        input3Button = new javax.swing.JButton();
        input0Button = new javax.swing.JButton();
        inputDotButton = new javax.swing.JButton();
        equalsButton = new javax.swing.JButton();
        inputDivButton12 = new javax.swing.JButton();
        inputMultiplyButton13 = new javax.swing.JButton();
        inputMinusButton = new javax.swing.JButton();
        inputPlusButton15 = new javax.swing.JButton();
        ClearOutputButton = new javax.swing.JButton();
        inputPlusButton16 = new javax.swing.JButton();
        inputPlusButton17 = new javax.swing.JButton();
        equalsButton1 = new javax.swing.JButton();
        inputPlusButton18 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        HeaderLabel.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        HeaderLabel.setText("Calculator");

        outputBox.setEditable(false);
        outputBox.setColumns(20);
        outputBox.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        outputBox.setLineWrap(true);
        outputBox.setRows(5);
        outputBox.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jScrollPane1.setViewportView(outputBox);

        input7Button.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        input7Button.setToolTipText("Seven");
        input7Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        input7Button.setLabel("7");
        input7Button.setPreferredSize(new java.awt.Dimension(70, 70));
        input7Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input7ButtonActionPerformed(evt);
            }
        });

        input8Button.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        input8Button.setText("8");
        input8Button.setToolTipText("Eight");
        input8Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        input8Button.setPreferredSize(new java.awt.Dimension(70, 70));
        input8Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input8ButtonActionPerformed(evt);
            }
        });

        input9Button.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        input9Button.setText("9");
        input9Button.setToolTipText("Nine");
        input9Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        input9Button.setPreferredSize(new java.awt.Dimension(70, 70));
        input9Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input9ButtonActionPerformed(evt);
            }
        });

        input4Button.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        input4Button.setText("4");
        input4Button.setToolTipText("Four");
        input4Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        input4Button.setPreferredSize(new java.awt.Dimension(70, 70));
        input4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input4ButtonActionPerformed(evt);
            }
        });

        input5Button.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        input5Button.setText("5");
        input5Button.setToolTipText("Five");
        input5Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        input5Button.setPreferredSize(new java.awt.Dimension(70, 70));
        input5Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input5ButtonActionPerformed(evt);
            }
        });

        input6Button.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        input6Button.setText("6");
        input6Button.setToolTipText("Six");
        input6Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        input6Button.setPreferredSize(new java.awt.Dimension(70, 70));
        input6Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input6ButtonActionPerformed(evt);
            }
        });

        input1Button.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        input1Button.setText("1");
        input1Button.setToolTipText("One");
        input1Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        input1Button.setPreferredSize(new java.awt.Dimension(70, 70));
        input1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input1ButtonActionPerformed(evt);
            }
        });

        input2Button.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        input2Button.setText("2");
        input2Button.setToolTipText("Two");
        input2Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        input2Button.setPreferredSize(new java.awt.Dimension(70, 70));
        input2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input2ButtonActionPerformed(evt);
            }
        });

        input3Button.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        input3Button.setText("3");
        input3Button.setToolTipText("Three");
        input3Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        input3Button.setPreferredSize(new java.awt.Dimension(70, 70));
        input3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input3ButtonActionPerformed(evt);
            }
        });

        input0Button.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        input0Button.setText("0");
        input0Button.setToolTipText("Zero");
        input0Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        input0Button.setPreferredSize(new java.awt.Dimension(70, 70));
        input0Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input0ButtonActionPerformed(evt);
            }
        });

        inputDotButton.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        inputDotButton.setText(".");
        inputDotButton.setToolTipText("Decimal point");
        inputDotButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inputDotButton.setPreferredSize(new java.awt.Dimension(70, 70));
        inputDotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDotButtonActionPerformed(evt);
            }
        });

        equalsButton.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        equalsButton.setText("=");
        equalsButton.setToolTipText("Equals");
        equalsButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        equalsButton.setPreferredSize(new java.awt.Dimension(70, 70));
        equalsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equalsButtonActionPerformed(evt);
            }
        });

        inputDivButton12.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        inputDivButton12.setText("/");
        inputDivButton12.setToolTipText("Divide");
        inputDivButton12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inputDivButton12.setPreferredSize(new java.awt.Dimension(70, 70));
        inputDivButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDivButton12ActionPerformed(evt);
            }
        });

        inputMultiplyButton13.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        inputMultiplyButton13.setText("*");
        inputMultiplyButton13.setToolTipText("Multiply");
        inputMultiplyButton13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inputMultiplyButton13.setPreferredSize(new java.awt.Dimension(70, 70));
        inputMultiplyButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputMultiplyButton13ActionPerformed(evt);
            }
        });

        inputMinusButton.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        inputMinusButton.setText("-");
        inputMinusButton.setToolTipText("Minus");
        inputMinusButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inputMinusButton.setPreferredSize(new java.awt.Dimension(70, 70));
        inputMinusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputMinusButtonActionPerformed(evt);
            }
        });

        inputPlusButton15.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        inputPlusButton15.setText("+");
        inputPlusButton15.setToolTipText("Plus");
        inputPlusButton15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inputPlusButton15.setPreferredSize(new java.awt.Dimension(70, 70));
        inputPlusButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPlusButton15ActionPerformed(evt);
            }
        });

        ClearOutputButton.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        ClearOutputButton.setText("C");
        ClearOutputButton.setToolTipText("Clears");
        ClearOutputButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ClearOutputButton.setPreferredSize(new java.awt.Dimension(70, 70));
        ClearOutputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearOutputButtonActionPerformed(evt);
            }
        });

        inputPlusButton16.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        inputPlusButton16.setText("^");
        inputPlusButton16.setToolTipText("Power");
        inputPlusButton16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inputPlusButton16.setPreferredSize(new java.awt.Dimension(70, 70));
        inputPlusButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPlusButton16ActionPerformed(evt);
            }
        });

        inputPlusButton17.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        inputPlusButton17.setText("%");
        inputPlusButton17.setToolTipText("Percentage");
        inputPlusButton17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inputPlusButton17.setPreferredSize(new java.awt.Dimension(70, 70));
        inputPlusButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPlusButton17ActionPerformed(evt);
            }
        });

        equalsButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        equalsButton1.setText("Ans");
        equalsButton1.setToolTipText("Previous answer");
        equalsButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        equalsButton1.setMaximumSize(new java.awt.Dimension(27, 53));
        equalsButton1.setMinimumSize(new java.awt.Dimension(27, 53));
        equalsButton1.setPreferredSize(new java.awt.Dimension(70, 70));
        equalsButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equalsButton1ActionPerformed(evt);
            }
        });

        inputPlusButton18.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        inputPlusButton18.setText("√");
        inputPlusButton18.setToolTipText("Root");
        inputPlusButton18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inputPlusButton18.setPreferredSize(new java.awt.Dimension(70, 70));
        inputPlusButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPlusButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(ClearOutputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(inputPlusButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(inputPlusButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(inputDivButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap(14, Short.MAX_VALUE)
                                    .addComponent(input1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(input2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(input3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(4, 4, 4))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(inputDotButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(input0Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(inputMinusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(input7Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(input4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(input5Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(input6Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(input8Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(input9Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputPlusButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inputPlusButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(equalsButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inputMultiplyButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(equalsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(HeaderLabel)
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClearOutputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPlusButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPlusButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputDivButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input9Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputMultiplyButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input7Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input8Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(input6Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(input5Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(input4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(equalsButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPlusButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputDotButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input0Button, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPlusButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputMinusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(equalsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        HeaderLabel.getAccessibleContext().setAccessibleName("HeaderLabel");
        input7Button.getAccessibleContext().setAccessibleName("7_Button");

        getAccessibleContext().setAccessibleName("CalculatorGUI");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void input7ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input7ButtonActionPerformed
        addSumPart("7");
    }//GEN-LAST:event_input7ButtonActionPerformed

    private void input8ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input8ButtonActionPerformed
        addSumPart("8");
    }//GEN-LAST:event_input8ButtonActionPerformed

    
    // REF 004 Changed button 9 to be assigned to number 9
    private void input9ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input9ButtonActionPerformed
        addSumPart("9");
    }//GEN-LAST:event_input9ButtonActionPerformed

    private void input4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input4ButtonActionPerformed
        addSumPart("4");
    }//GEN-LAST:event_input4ButtonActionPerformed

    private void input5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input5ButtonActionPerformed
        addSumPart("5");
    }//GEN-LAST:event_input5ButtonActionPerformed

    private void input6ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input6ButtonActionPerformed
        addSumPart("6");
    }//GEN-LAST:event_input6ButtonActionPerformed

    // REF 005 Changed button 1 to be assigned to number 1
    private void input1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input1ButtonActionPerformed
        addSumPart("1");
    }//GEN-LAST:event_input1ButtonActionPerformed

    private void input2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input2ButtonActionPerformed
        addSumPart("2");
    }//GEN-LAST:event_input2ButtonActionPerformed

    private void input3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input3ButtonActionPerformed
        addSumPart("3");
    }//GEN-LAST:event_input3ButtonActionPerformed

    private void inputDotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDotButtonActionPerformed
        if(dotFlag){
            addSumPart(".");
            dotFlag = false;
        }
    }//GEN-LAST:event_inputDotButtonActionPerformed

    private void input0ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input0ButtonActionPerformed
            addSumPart("0");
    }//GEN-LAST:event_input0ButtonActionPerformed

    private void equalsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equalsButtonActionPerformed
        addSumPart("=");
    }//GEN-LAST:event_equalsButtonActionPerformed

    private void inputDivButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDivButton12ActionPerformed
        addSumPart("/");
    }//GEN-LAST:event_inputDivButton12ActionPerformed

    private void inputMultiplyButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMultiplyButton13ActionPerformed
        addSumPart("*");
    }//GEN-LAST:event_inputMultiplyButton13ActionPerformed

    private void inputMinusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMinusButtonActionPerformed
        addSumPart("-");
    }//GEN-LAST:event_inputMinusButtonActionPerformed

    private void inputPlusButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPlusButton15ActionPerformed
        addSumPart("+");
    }//GEN-LAST:event_inputPlusButton15ActionPerformed

    private void ClearOutputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearOutputButtonActionPerformed
        reset();
        this.outputBox.setText("");
    }//GEN-LAST:event_ClearOutputButtonActionPerformed

    private void inputPlusButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPlusButton16ActionPerformed
        addSumPart("^");
    }//GEN-LAST:event_inputPlusButton16ActionPerformed

    private void inputPlusButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPlusButton17ActionPerformed
        addSumPart("% of");
    }//GEN-LAST:event_inputPlusButton17ActionPerformed

    private void equalsButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equalsButton1ActionPerformed
        addSumPart(ans);
    }//GEN-LAST:event_equalsButton1ActionPerformed

    private void inputPlusButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPlusButton18ActionPerformed
        addSumPart("√");
    }//GEN-LAST:event_inputPlusButton18ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearOutputButton;
    private javax.swing.JLabel HeaderLabel;
    private javax.swing.JButton equalsButton;
    private javax.swing.JButton equalsButton1;
    private javax.swing.JButton input0Button;
    private javax.swing.JButton input1Button;
    private javax.swing.JButton input2Button;
    private javax.swing.JButton input3Button;
    private javax.swing.JButton input4Button;
    private javax.swing.JButton input5Button;
    private javax.swing.JButton input6Button;
    private javax.swing.JButton input7Button;
    private javax.swing.JButton input8Button;
    private javax.swing.JButton input9Button;
    private javax.swing.JButton inputDivButton12;
    private javax.swing.JButton inputDotButton;
    private javax.swing.JButton inputMinusButton;
    private javax.swing.JButton inputMultiplyButton13;
    private javax.swing.JButton inputPlusButton15;
    private javax.swing.JButton inputPlusButton16;
    private javax.swing.JButton inputPlusButton17;
    private javax.swing.JButton inputPlusButton18;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea outputBox;
    // End of variables declaration//GEN-END:variables
}
