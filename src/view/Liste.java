package view;

import dao.ClientDAO;
import dao.DaoException;
import entities.Client;
import entities.ListeClient;
import entities.Prospect;
import utilities.SocieteChoix;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

import static entities.ListeClient.listeClient;
import static entities.ListeProspect.listeProspect;
import static utilities.RegexPattern.DATE_FORMATTER;

/**
 * La classe Liste affiche une table contenant les informations des Clients ou des Prospects.
 * Elle permet de visualiser les données en fonction du type choisi.
 */
public class Liste extends JFrame {
    private JPanel contentPane;
    private JButton buttonAccueil;
    private JButton buttonQuitter;
    private JTable table1;
    private SocieteChoix societeChoix;

    /**
     * Constructeur de la classe Liste.
     * @param p_societeChoix le type d'entité (Client ou Prospect) dont on souhaite afficher la liste.
     */
    public Liste(SocieteChoix p_societeChoix) throws DaoException {
        getRootPane().setDefaultButton(buttonAccueil);
        initFrame();
        listeners();
        remplissageJTable(p_societeChoix);
    }

    /**
     * Initialise la fenêtre avec les paramètres nécessaires.
     */
    private void initFrame() {
        setContentPane(contentPane);
        setSize(1200, 400);
        setVisible(false);
    }

    /**
     * Ajoute les écouteurs d'événements pour les boutons et les actions de la fenêtre.
     */
    private void listeners() {
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

        // Gestion de la fermeture de la fenêtre via la croix.
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // Gestion de la fermeture via la touche ÉCHAP.
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    /**
     * Action exécutée lors de la confirmation avec le bouton "Accueil".
     */
    private void onOK() {
        dispose();
    }

    /**
     * Action exécutée lors de l'annulation ou de la fermeture de la fenêtre.
     */
    private void onCancel() {
        dispose();
    }

    /**
     * Remplit le tableau JTable avec les données des Clients ou des Prospects.
     * @param p_societeChoix le type d'entité (Client ou Prospect) à afficher dans le tableau.
     */
    private void remplissageJTable(SocieteChoix p_societeChoix) throws DaoException {
        String[] entetes;
        DefaultTableModel tableModel;

        if (p_societeChoix == SocieteChoix.CLIENT) {
            // Configuration pour la liste des Clients
            setTitle("Liste clients");
            entetes = new String[]{"ID", "Raison Sociale", "Téléphone", "Email", "Commentaire", "Adresse", "Chiffre d'affaires", "Nombre d'employés"};
            tableModel = new DefaultTableModel(entetes, 0);
            tableModel.addRow(entetes);

            List<Client> ClientSList = new ClientDAO().findAll();

            // Ajout des données des Clients dans le tableau
            for (Client listeClient : ClientSList) {
                tableModel.addRow(new Object[]{
                        listeClient.getIdSociete(),
                        listeClient.getRaisonSocialeSociete(),
                        listeClient.getTelSociete(),
                        listeClient.getEmailSociete(),
                        listeClient.getCommentaireSociete(),
                        listeClient.getAdresseSociete(),
                        listeClient.getChiffreAffaire(),
                        listeClient.getNbEmploye()
                });
            }
            table1.setModel(tableModel);
        } else if (p_societeChoix == SocieteChoix.PROSPECT) {
            // Configuration pour la liste des Prospects
            setTitle("Liste prospects");
            entetes = new String[]{"ID", "Raison Sociale", "Téléphone", "Email", "Commentaire", "Adresse", "Date Prospection", "Intérêt"};
            tableModel = new DefaultTableModel(entetes, 0);
            tableModel.addRow(entetes);

            // Ajout des données des Prospects dans le tableau
            for (Prospect listeProspect : listeProspect) {
                tableModel.addRow(new Object[]{
                        listeProspect.getIdSociete(),
                        listeProspect.getRaisonSocialeSociete(),
                        listeProspect.getTelSociete(),
                        listeProspect.getEmailSociete(),
                        listeProspect.getCommentaireSociete(),
                        listeProspect.getAdresseSociete(),
                        listeProspect.getDateProspection().format(DATE_FORMATTER),
                        listeProspect.getInterested()
                });
            }
            table1.setModel(tableModel);
        }
    }
}
