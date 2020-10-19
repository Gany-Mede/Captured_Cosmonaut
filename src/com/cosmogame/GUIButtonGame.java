package com.cosmogame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUIButtonGame {
    JFrame frame = new JFrame("Match colors");
    JButton magentaLeft = new JButton();
    JButton greenLeft = new JButton();
    JButton yellowLeft = new JButton();
    JButton cyanLeft = new JButton();
    JButton magentaRight = new JButton();
    JButton cyanRight = new JButton();
    JButton yellowRight = new JButton();
    JButton greenRight = new JButton();
    JLabel label = new JLabel();
    Color defaultColor = Color.GRAY;
    ArrayList<JButton> buttonList = new ArrayList<>();
    int rightCount = 0;

    public void start() {
        guiBuild();
        ArrayList<JButton> arr = new ArrayList<>();
        arr.add(greenLeft);
    }

    public void checkButton(JButton button) {
        if (buttonList.size() < 2) {
            buttonList.add(button);
            if(buttonList.size()==2){
                seeMatch(buttonList);
            }
        }
    }

    public void seeMatch(ArrayList list) {
        //green
        if (list.get(0).equals(greenLeft) && list.get(1).equals(greenRight)){
            rightCount++;
        }
        if (list.get(0).equals(greenRight) && list.get(1).equals(greenLeft)){
            rightCount++;
        }
        if (list.get(0).equals(greenRight) && !list.get(1).equals(greenLeft)){
            greenLeft.setBackground(defaultColor);
            greenRight.setBackground(defaultColor);
        }
        if (list.get(0).equals(greenLeft) && !list.get(1).equals(greenRight)){
            greenLeft.setBackground(defaultColor);
            greenRight.setBackground(defaultColor);
        }
        //yellow
        if (list.get(0).equals(yellowLeft) && list.get(1).equals(yellowRight)){
            rightCount++;
        }
        if (list.get(0).equals(yellowRight) && list.get(1).equals(yellowLeft)){
            rightCount++;
        }
        if (list.get(0).equals(yellowRight) && !list.get(1).equals(yellowLeft)){
            yellowLeft.setBackground(defaultColor);
            yellowRight.setBackground(defaultColor);
        }
        if (list.get(0).equals(yellowLeft) && !list.get(1).equals(yellowRight)){
            yellowLeft.setBackground(defaultColor);
            yellowRight.setBackground(defaultColor);
        }

        //cyan
        if (list.get(0).equals(cyanLeft) && list.get(1).equals(cyanRight)){
            rightCount++;
        }
        if (list.get(0).equals(cyanRight) && list.get(1).equals(cyanLeft)){
            rightCount++;
        }
        if (list.get(0).equals(cyanRight) && !list.get(1).equals(cyanLeft)){
            cyanLeft.setBackground(defaultColor);
            cyanRight.setBackground(defaultColor);
        }
        if (list.get(0).equals(cyanLeft) && !list.get(1).equals(cyanRight)){
            cyanLeft.setBackground(defaultColor);
            cyanRight.setBackground(defaultColor);
        }
        //magenta
        if (list.get(0).equals(magentaLeft) && list.get(1).equals(magentaRight)){
            rightCount++;
        }
        if (list.get(0).equals(magentaRight) && list.get(1).equals(magentaLeft)){
            rightCount++;
        }
        if (list.get(0).equals(magentaRight) && !list.get(1).equals(magentaLeft)){
            magentaRight.setBackground(defaultColor);
            magentaLeft.setBackground(defaultColor);
        }
        if (list.get(0).equals(magentaLeft) && !list.get(1).equals(magentaRight)){
            magentaLeft.setBackground(defaultColor);
            magentaRight.setBackground(defaultColor);
        }
        list.clear();
        if(rightCount==4){
            label.setText("You won!");
        }
    }

    public void guiBuild() {

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        JPanel panelCenter = new JPanel();

        BoxLayout layoutLeft = new BoxLayout(panelLeft, BoxLayout.Y_AXIS);
        BoxLayout layoutRight = new BoxLayout(panelRight, BoxLayout.Y_AXIS);
        BoxLayout layoutCenter = new BoxLayout(panelCenter, BoxLayout.Y_AXIS);

        panelLeft.setLayout(layoutLeft);
        panelRight.setLayout(layoutRight);
        panelCenter.setLayout(layoutCenter);

        //Green Left
        greenLeft.setOpaque(true);
        greenLeft.setBackground(defaultColor);
        greenLeft.setBorderPainted(false);
        greenLeft.addActionListener(e -> {
            greenLeft.setBackground(Color.green);
            checkButton(greenLeft);
        });


        //Magenta Left
        magentaLeft.setOpaque(true);
        magentaLeft.setBackground(defaultColor);
        magentaLeft.setBorderPainted(false);
        magentaLeft.addActionListener(e -> {
            magentaLeft.setBackground(Color.magenta);
            checkButton(magentaLeft);
        });

        //Yellow Left
        yellowLeft.setOpaque(true);
        yellowLeft.setBackground(defaultColor);
        yellowLeft.setBorderPainted(false);
        yellowLeft.addActionListener(e -> {
            yellowLeft.setBackground(Color.yellow);
            checkButton(yellowLeft);
        });

        //Cyan Left
        cyanLeft.setOpaque(true);
        cyanLeft.setBackground(defaultColor);
        cyanLeft.setBorderPainted(false);
        cyanLeft.addActionListener(e -> {
            cyanLeft.setBackground(Color.cyan);
            checkButton(cyanLeft);
        });

        //Magenta Right
        magentaRight.setOpaque(true);
        magentaRight.setBackground(defaultColor);
        magentaRight.setBorderPainted(false);
        magentaRight.addActionListener(e -> {
            magentaRight.setBackground(Color.magenta);
            checkButton(magentaRight);
        });

        //Cyan Right
        cyanRight.setOpaque(true);
        cyanRight.setBackground(defaultColor);
        cyanRight.setBorderPainted(false);
        cyanRight.addActionListener(e -> {
            cyanRight.setBackground(Color.cyan);
            checkButton(cyanRight);
        });

        //Yellow Right
        yellowRight.setOpaque(true);
        yellowRight.setBackground(defaultColor);
        yellowRight.setBorderPainted(false);
        yellowRight.addActionListener(e -> {
            yellowRight.setBackground(Color.yellow);
            checkButton(yellowRight);
        });

        //Green Right
        greenRight.setOpaque(true);
        greenRight.setBackground(defaultColor);
        greenRight.setBorderPainted(false);
        greenRight.addActionListener(e -> {
            greenRight.setBackground(Color.green);
            checkButton(greenRight);
        });


        greenLeft.setAlignmentX(Component.LEFT_ALIGNMENT);
        magentaLeft.setAlignmentX(Component.LEFT_ALIGNMENT);
        yellowLeft.setAlignmentX(Component.LEFT_ALIGNMENT);
        cyanLeft.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelLeft.add(greenLeft);
        panelLeft.add(magentaLeft);
        panelLeft.add(yellowLeft);
        panelLeft.add(cyanLeft);


        magentaRight.setAlignmentX(Component.RIGHT_ALIGNMENT);
        cyanRight.setAlignmentX(Component.RIGHT_ALIGNMENT);
        yellowRight.setAlignmentX(Component.RIGHT_ALIGNMENT);
        greenRight.setAlignmentX(Component.RIGHT_ALIGNMENT);
        label.setAlignmentX(Component.BOTTOM_ALIGNMENT);
        panelCenter.add(label);
        panelRight.add(magentaRight);
        panelRight.add(cyanRight);
        panelRight.add(yellowRight);
        panelRight.add(greenRight);
        label.setText("Match Colors");

        frame.setLayout(new FlowLayout());
        frame.add(panelLeft);
        frame.add(panelCenter);
        frame.add(panelRight);
        //frame.pack();
        frame.setVisible(true);

    }

}
