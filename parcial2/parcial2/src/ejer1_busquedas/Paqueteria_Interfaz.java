package ejer1_busquedas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Paqueteria_Interfaz {
    private JPanel Ventana;
    private JTabbedPane tabbedPane1;
    private JTextField txtfPeso;
    private JButton buscarButton;
    private JTextField txtPesoBinario;
    private JButton btnBuscarBinario;
    private JComboBox cbxCuiRecepcion;
    private JComboBox cbxCuiEntrega;
    private JTextField textField2;
    private JComboBox cbxEstado;
    private JButton btnIngresar;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JComboBox comboBox1;
    private JTextArea textArea3;

    private List<Paqueteria> listadoPaquetes = new ArrayList<>();
    private Lista lista = new Lista();

    public Paqueteria_Interfaz(){
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double peso = Double.parseDouble(txtfPeso.getText());
                String ciudadRec = cbxCuiRecepcion.getSelectedItem().toString();
                String ciudadEnt = cbxCuiEntrega.getSelectedItem().toString();
                String cedula = JOptionPane.showInputDialog("Ingrese la cédula del receptor:");

                lista.adicionarElemento(peso, ciudadRec, ciudadEnt, cedula);

                textArea1.setText("Paquete agregado correctamente.\n");
                textArea1.append("Total paquetes: " + lista.getListadoPaquetes().size());
            }
        });


        btnBuscarBinario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double pesoBuscado = Double.parseDouble(txtPesoBinario.getText());

                Paqueteria encontrado = lista.busquedaBinarioPeso(pesoBuscado);

                if (encontrado == null) {
                    textArea2.setText("No existe paquete con ese peso.");
                } else {
                    textArea2.setText("Paquete encontrado:\n" + encontrado.toString());
                }

            }
        });


        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciudad = comboBox1.getSelectedItem().toString();
                String cedula = textField2.getText();

                Paqueteria p = lista.busquedaSecuencial(ciudad, cedula);


                if (p == null) {
                    textArea3.setText("No existe paquete con esos datos.");
                } else {
                    textArea3.setText("Paquete encontrado:\n" + p.toString());
                }
            }

        });
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("Paquetería");
        frame.setContentPane(new Paqueteria_Interfaz().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }










}
