package view;

import entities.*;
import utilities.SocieteChoix;

import javax.swing.*;
import java.awt.event.*;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;

import static logging.MonLogger.LOGGER;

/**
 * La classe MiseAjour représente une boîte de dialogue permettant la gestion des entités Client et Prospect.
 * Elle permet d'ajouter ou de mettre à jour les informations associées à ces entités.
 */
public class MiseAjour extends JDialog {
    private JPanel contentPane;
    private JButton buttonAccueil;
    private JButton buttonQuitter;
    private JLabel change;
    private JPanel majClient;
    private JTextArea commentaire;
    private JLabel chiffreAffaire;
    private JLabel nbEmploye;
    private JLabel interet;
    private JLabel email;
    private JLabel dateProspection;
    private JTextField IdField;
    private JTextField raisonSocialeField;
    private JTextField adresseField;
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
    private Client client;
    private Prospect prospect;

    /**
     * Constructeur pour créer une nouvelle boîte de dialogue pour ajouter ou modifier un Client ou un Prospect.
     * @param societeChoix le type d'entité (Client ou Prospect) à gérer.
     */
    public MiseAjour(SocieteChoix societeChoix) {
        this.societeChoix = societeChoix;
        initFrame();
        listeners();
        changementLabel();
        getRootPane().setDefaultButton(buttonAccueil);
        if (societeChoix == SocieteChoix.CLIENT) {
            Client.renvoiProchainId();
            IdField.setText(String.valueOf(Client.renvoiProchainId()));
        } else if (societeChoix == SocieteChoix.PROSPECT) {
            Prospect.renvoiProchainId();
            IdField.setText(String.valueOf(Prospect.renvoiProchainId()));
        }
    }

    /**
     * Constructeur pour la mise à jour des informations d'un Client.
     * @param societeChoix le type d'entité (Client ou Prospect).
     * @param client l'objet Client à modifier.
     * @param isReadOnly indique si les champs doivent être en lecture seule.
     */
    public MiseAjour(SocieteChoix societeChoix, Client client, boolean isReadOnly) {
        this.societeChoix = societeChoix;
        this.client = client;
        initFrame();
        listeners();
        changementLabel();
        preRemplirChamps(societeChoix);
        if (isReadOnly) {
            rendreChampsNonEditables();
        } else {
            rendreSeulementIdNonEditable();
        }
    }

    /**
     * Constructeur pour la mise à jour des informations d'un Prospect.
     * @param societeChoix le type d'entité (Client ou Prospect).
     * @param prospect l'objet Prospect à modifier.
     * @param isReadOnly indique si les champs doivent être en lecture seule.
     */
    public MiseAjour(SocieteChoix societeChoix, Prospect prospect, boolean isReadOnly) {
        this.societeChoix = societeChoix;
        this.prospect = prospect;
        initFrame();
        listeners();
        changementLabel();
        preRemplirChamps(societeChoix);
        if (isReadOnly) {
            rendreChampsNonEditables();
        } else {
            rendreSeulementIdNonEditable();
        }
    }

    /**
     * Initialise les paramètres de la fenêtre.
     */
    private void initFrame() {
        setTitle("MiseAjour");
        setSize(900, 600);
        setContentPane(contentPane);
    }

    /**
     * Modifie l'affichage des champs et des labels en fonction du type d'entité.
     */
    private void changementLabel() {
        if (societeChoix == SocieteChoix.CLIENT) {
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

    /**
     * Remplit les champs avec les informations de l'entité à modifier.
     * @param p_societeChoix le type d'entité (Client ou Prospect).
     */
    private void preRemplirChamps(SocieteChoix p_societeChoix) {
        if (p_societeChoix == SocieteChoix.CLIENT) {
            IdField.setText(String.valueOf(client.renvoiProchainId()));
            raisonSocialeField.setText(client.getRaisonSocialeSociete());
            telephoneField.setText(client.getTelSociete());
            emailField.setText(client.getEmailSociete());
            adresseField.setEditable(false);
            numRueField.setText(client.getAdresseSociete().getNumeroRue());
            nomRueField.setText(client.getAdresseSociete().getNomRue());
            codePostalField.setText(client.getAdresseSociete().getCodePostal());
            villeField.setText(client.getAdresseSociete().getVille());
            chiffreAffaireField.setText(String.valueOf(client.getChiffreAffaire()));
            nbEmployeField.setText(String.valueOf(client.getNbEmploye()));
        } else if (p_societeChoix == SocieteChoix.PROSPECT) {
            IdField.setText(String.valueOf(prospect.renvoiProchainId()));
            raisonSocialeField.setText(prospect.getRaisonSocialeSociete());
            telephoneField.setText(prospect.getTelSociete());
            emailField.setText(prospect.getEmailSociete());
            adresseField.setEditable(false);
            numRueField.setText(prospect.getAdresseSociete().getNumeroRue());
            nomRueField.setText(prospect.getAdresseSociete().getNomRue());
            codePostalField.setText(prospect.getAdresseSociete().getCodePostal());
            villeField.setText(prospect.getAdresseSociete().getVille());
            dateProspectField.setText(String.valueOf(prospect.getDateProspection()));
            boxInteret.getSelectedItem();
        }
    }

    /**
     * Rend uniquement le champ ID non éditable, tout en laissant les autres champs modifiables.
     */
    private void rendreSeulementIdNonEditable() {
        IdField.setEditable(false);
        raisonSocialeField.setEditable(true);
        telephoneField.setEditable(true);
        emailField.setEditable(true);
        adresseField.setEditable(false);
        numRueField.setEditable(true);
        nomRueField.setEditable(true);
        codePostalField.setEditable(true);
        villeField.setEditable(true);
        if (societeChoix == SocieteChoix.CLIENT) {
            chiffreAffaireField.setEditable(true);
            nbEmployeField.setEditable(true);
        } else if (societeChoix == SocieteChoix.PROSPECT) {
            dateProspectField.setEditable(true);
            boxInteret.setEnabled(true);
        }
    }

    /**
     * Rend tous les champs non éditables.
     */
    private void rendreChampsNonEditables() {
        IdField.setEditable(false);
        raisonSocialeField.setEditable(false);
        telephoneField.setEditable(false);
        emailField.setEditable(false);
        adresseField.setEditable(false);
        numRueField.setEditable(false);
        nomRueField.setEditable(false);
        codePostalField.setEditable(false);
        villeField.setEditable(false);
        if (societeChoix == SocieteChoix.CLIENT) {
            chiffreAffaireField.setEditable(false);
            nbEmployeField.setEditable(false);
        } else if (societeChoix == SocieteChoix.PROSPECT) {
            dateProspectField.setEditable(false);
            boxInteret.setEnabled(false);
        }
    }

    /**
     * Ajoute les écouteurs d'événements pour les différents composants de la fenêtre.
     */
    private void listeners() {
        validerCréationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (societeChoix == SocieteChoix.CLIENT) {
                        Client client = new Client(
                                raisonSocialeField.getText().trim(),
                                telephoneField.getText().trim(),
                                emailField.getText().trim(),
                                commentaire.getText().trim(),
                                new Adresse(
                                        numRueField.getText().trim(),
                                        nomRueField.getText().trim(),
                                        codePostalField.getText().trim(),
                                        villeField.getText().trim()
                                ),
                                Long.parseLong(chiffreAffaireField.getText().trim()),
                                Integer.parseInt(nbEmployeField.getText().trim())
                        );
                        ListeClient.ajouterClient(client);
                        JOptionPane.showMessageDialog(contentPane, "Client ajouté avec succès !");
                    } else if (societeChoix == SocieteChoix.PROSPECT) {
                        Prospect prospect = new Prospect(
                                raisonSocialeField.getText().trim(),
                                telephoneField.getText().trim(),
                                emailField.getText().trim(),
                                commentaire.getText().trim(),
                                new Adresse(
                                        numRueField.getText().trim(),
                                        nomRueField.getText().trim(),
                                        codePostalField.getText().trim(),
                                        villeField.getText().trim()
                                ),
                                dateProspectField.getText(),
                                boxInteret.getSelectedItem().toString()
                        );
                        ListeProspect.ajouterProspect(prospect);
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

        buttonAccueil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    /**
     * Action exécutée lors de la confirmation.
     */
    private void onOK() {
        dispose();
    }

    /**
     * Action exécutée lors de l'annulation.
     */
    private void onCancel() {
        dispose();
    }
}


