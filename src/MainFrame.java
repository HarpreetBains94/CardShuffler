import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame{

    public MainFrame(String title){
        super(title);


        /**
         * Creating and formatting the window
         */
        Dimension size = getPreferredSize();

        setLayout(new BorderLayout());

        this.setLocationRelativeTo(null);

        this.setResizable(false);

        JTextArea textArea = new JTextArea();

        JLabel cardNo = new JLabel("No. of cards to draw: ");
        JTextField cardNoField = new JTextField(5);
        cardNoField.setToolTipText("Must be a whole number between 1 and 52");

        JButton draw = new JButton("Draw");
        draw.setPreferredSize(new Dimension(200, 30));
        JButton shuffle = new JButton("Shuffle");
        shuffle.setPreferredSize(new Dimension(200, 30));
        JButton newDeck = new JButton("New Deck");
        newDeck.setPreferredSize(new Dimension(200, 30));
        JButton drawSort = new JButton("Draw Sorted");
        drawSort.setPreferredSize(new Dimension(200, 30));

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(cardNo, gbc);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(cardNoField, gbc);

        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(newDeck, gbc);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(shuffle, gbc);

        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(draw, gbc);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(drawSort, gbc);

        gbc.weighty = 10;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(textArea, gbc);

        final Deck deck = new Deck();

        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                int cardsToDraw;
                try{
                    cardsToDraw = Integer.parseInt(cardNoField.getText());
                    if(cardsToDraw<53 && cardsToDraw>0){
                        if(deck.getDeck().size()>cardsToDraw) {
                            textArea.append("Cards drawn: \n\n");
                            ArrayList<Card> drawnCards = deck.draw(cardsToDraw);
                            for (Card card : drawnCards) {
                                textArea.append(card.toString() + "\n");
                            }
                        }else{
                            textArea.append("There is not enough cards left in the deck.\n" +
                                    "Please reset the deck.");
                        }
                    }else {
                        textArea.append("That was not a valid number, please try again.\n" +
                                "(Whole numbers between 1 and 52 are required)");
                    }
                }catch (NumberFormatException err){
                    textArea.append("That was not a valid number, please try again.\n" +
                            "(Whole numbers between 1 and 52 are required)");
                }
            }
        });

        shuffle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                deck.shuffle();
            }
        });

        drawSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                int cardsToDraw;
                try{
                    cardsToDraw = Integer.parseInt(cardNoField.getText());
                    if(cardsToDraw<53 && cardsToDraw>0){
                        if(deck.getDeck().size()>cardsToDraw) {
                            textArea.append("Cards drawn: \n\n");
                            ArrayList<Card> drawnCards = deck.draw(cardsToDraw);
                            Deck.sort(drawnCards);
                            for (Card card : drawnCards) {
                                textArea.append(card.toString() + "\n");
                            }
                        }else{
                            textArea.append("There is not enough cards left in the deck.\n" +
                                    "Please reset the deck.");
                        }
                    }else {
                        textArea.append("That was not a valid number, please try again.\n" +
                                "(Whole numbers between 1 and 52 are required)");
                    }
                }catch (NumberFormatException err){
                    textArea.append("That was not a valid number, please try again.\n" +
                            "(Whole numbers between 1 and 52 are required)");
                }
            }
        });

        newDeck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                deck.newDeck();
            }
        });

    }
}
