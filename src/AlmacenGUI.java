import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlmacenGUI {
    private Almacen almacen;
    private JFrame frame;
    private JTextField numeroField;
    private JTextField nombreField;
    private JTextField buscarField;
    private JTextArea displayArea;

    public AlmacenGUI() {
        almacen = new Almacen(3, 6);
        frame = new JFrame("Gestión de Almacén");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel numeroLabel = new JLabel("Número:");
        numeroLabel.setBounds(10, 10, 80, 25);
        frame.add(numeroLabel);

        numeroField = new JTextField();
        numeroField.setBounds(100, 10, 160, 25);
        frame.add(numeroField);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(10, 40, 80, 25);
        frame.add(nombreLabel);

        nombreField = new JTextField();
        nombreField.setBounds(100, 40, 160, 25);
        frame.add(nombreField);

        JButton agregarButton = new JButton("Agregar Caja");
        agregarButton.setBounds(10, 70, 150, 25);
        frame.add(agregarButton);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(numeroField.getText());
                String nombre = nombreField.getText();
                Caja caja = new Caja(numero, nombre);
                if (almacen.agregarCaja(caja)) {
                    displayArea.setText("Caja agregada exitosamente.");
                } else {
                    displayArea.setText("No hay espacio en las pilas.");
                }
            }
        });

        JLabel buscarLabel = new JLabel("Buscar Número:");
        buscarLabel.setBounds(10, 100, 100, 25);
        frame.add(buscarLabel);

        buscarField = new JTextField();
        buscarField.setBounds(120, 100, 140, 25);
        frame.add(buscarField);

        JButton buscarButton = new JButton("Buscar Caja");
        buscarButton.setBounds(10, 130, 150, 25);
        frame.add(buscarButton);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(buscarField.getText());
                String resultado = almacen.buscarCaja(numero);
                displayArea.setText(resultado);
            }
        });

        JButton sacarButton = new JButton("Sacar Caja");
        sacarButton.setBounds(10, 160, 150, 25);
        frame.add(sacarButton);
        sacarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(buscarField.getText());
                String resultado = almacen.sacarCaja(numero);
                displayArea.setText(resultado);
            }
        });

        JButton imprimirButton = new JButton("Imprimir Pilas");
        imprimirButton.setBounds(10, 190, 150, 25);
        frame.add(imprimirButton);
        imprimirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                almacen.imprimirPilas();
            }
        });

        displayArea = new JTextArea();
        displayArea.setBounds(10, 220, 360, 40);
        frame.add(displayArea);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new AlmacenGUI();
    }
}