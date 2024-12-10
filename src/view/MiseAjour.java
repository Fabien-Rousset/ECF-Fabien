package view;

import entities.*;
import utilities.Interet;
import utilities.SocieteChoix;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;

import static logging.MonLogger.LOGGER;

public class MiseAjour extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel change;
    private JPanel majClient;
    private JTextArea commentaire;
    private JLabel chiffreAffaire;
    private JLabel nbEmploye;
    private JLabel interet;
    private JLabel email;
    private JLabel dateProspection;
    private JTextField textField1;
    private JTextField raisonSocialeField;
    private JTextField textField5;
    private JTextField numRueField;
    private JTextField nomRueField;
    private JTextField codePostalField;
    private JTextField villeField;
    private JTextField telephoneField;

    private JTextField chiffreAffaireField;
    private JTextField nbEmployeField;
    private JButton validerCréationButton;
    private JComboBox boxInteret;
    private JTextField dateProspectField;
    private JTextField emailField;

    private final SocieteChoix societeChoix;

    public MiseAjour(SocieteChoix societeChoix) {
        this.societeChoix = societeChoix;
        initFrame();
        listeners();
        changementLabel();
        getRootPane().setDefaultButton(buttonOK);

    }



    private void initFrame() {
        setTitle("MiseAjour");
        setSize(600, 1000);
        setContentPane(contentPane);
    }

    private void changementLabel(){
    if (societeChoix == SocieteChoix.CLIENT){
        chiffreAffaire.setVisible(true);
        nbEmploye.setVisible(true);
        interet.setVisible(false);
        dateProspection.setVisible(false);
        dateProspectField.setVisible(false);
        boxInteret.setVisible(false);

    } else if (societeChoix == SocieteChoix.PROSPECT) {
        chiffreAffaire.setVisible(false);
        nbEmploye.setVisible(false);
        interet.setVisible(true);
        dateProspection.setVisible(true);
        chiffreAffaireField.setVisible(false);
        nbEmployeField.setVisible(false);
    }
}


    private void listeners() {


        validerCréationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (societeChoix == SocieteChoix.CLIENT) {
                        // Créer un nouveau Client à partir des champs de la classe MiseAjour
                        Client client = new Client(
                                raisonSocialeField.getText().trim(), // Raison sociale
                                telephoneField.getText().trim(), // Téléphone
                                emailField.getText().trim(), // Email
                                commentaire.getText().trim(), // Commentaire
                                new Adresse(
                                        numRueField.getText().trim(), // Numéro de rue
                                        nomRueField.getText().trim(), // Nom de la rue
                                        codePostalField.getText().trim(), // Code postal
                                        villeField.getText().trim() // Ville
                                ),
                                Long.parseLong(chiffreAffaireField.getText().trim()), // Chiffre d'affaires
                                Integer.parseInt(nbEmployeField.getText().trim()) // Nombre d'employés
                        );

                        // Ajouter le client à la liste
                        new ListeClient().ajouterClient(client);

                        // Afficher un message de confirmation
                        JOptionPane.showMessageDialog(contentPane, "Client ajouté avec succès !");
                    } else if (societeChoix == SocieteChoix.PROSPECT) {
                        // Créer un nouveau Prospect à partir des champs de la classe MiseAjour
                        Prospect prospect = new Prospect(
                                raisonSocialeField.getText().trim(), // Raison sociale
                                telephoneField.getText().trim(), // Téléphone
                                emailField.getText().trim(), // Email
                                commentaire.getText().trim(), // Commentaire
                                new Adresse(
                                        numRueField.getText().trim(), // Numéro de rue
                                        nomRueField.getText().trim(), // Nom de la rue
                                        codePostalField.getText().trim(), // Code postal
                                        villeField.getText().trim() // Ville
                                ),
                                LocalDate.parse(dateProspection.getText().trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy")), // Date de prospection
                                boxInteret.getSelectedItem().toString() // Intéressé ou non
                        );

                        // Ajouter le prospect à la liste
                        new ListeProspect().ajouterProspect(prospect);

                        // Afficher un message de confirmation
                        JOptionPane.showMessageDialog(contentPane, "Prospect ajouté avec succès !");
                    }
                } catch (DateTimeParseException de) {
                    LOGGER.log(Level.WARNING, "Erreur de parsing de la date", de);
                    JOptionPane.showMessageDialog(contentPane, "Date invalide : La date doit être au format jj/MM/aaaa et être valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException nfe) {
                    LOGGER.log(Level.WARNING, "Erreur de parsing d'un nombre", nfe);
                    JOptionPane.showMessageDialog(contentPane, "Veuillez saisir un nombre valide pour le chiffre d'affaires ou le nombre d'employés.", "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (ExoException ee) {
                    LOGGER.log(Level.WARNING, "Erreur spécifique de l'application", ee);
                    JOptionPane.showMessageDialog(contentPane, "Erreur : " + ee.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    LOGGER.log(Level.SEVERE, "Une erreur inattendue s'est produite", ex);
                    JOptionPane.showMessageDialog(contentPane, "Une erreur inattendue s'est produite : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });




        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }


    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        MiseAjour dialog = new MiseAjour(SocieteChoix.CLIENT);
        MiseAjour dialog2 = new MiseAjour(SocieteChoix.PROSPECT);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
