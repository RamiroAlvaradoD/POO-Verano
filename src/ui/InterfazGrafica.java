package ui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dominio.PlanStreaming;
import sistema.Sistema;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InterfazGrafica extends JFrame {

    private Sistema sistema;

    // ====== Componentes Swing ======
    private JTextField txtNombreCliente;

    private JComboBox<String> cbPlataforma;
    private JComboBox<String> cbTipoPlan;

    private JSpinner spPantallas;

    private JSlider slCalidad;

    private JCheckBox chkSinAnuncios;
    private JCheckBox chkDescargas;
    private JCheckBox chkDeportes;

    private JList<String> listPacks;
    private DefaultListModel<String> listModelPacks;

    private JTextArea txtResumen;

    private JButton btnCalcular;

    public InterfazGrafica(Sistema sistema) {
        this.sistema = sistema;

        setTitle("Streaming Plan Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 450);
        setLocationRelativeTo(null); 

        inicializarComponentes();
        construirLayout();
        configurarEventos();
    }

    private void inicializarComponentes() {

        txtNombreCliente = new JTextField(15);

        cbPlataforma = new JComboBox<>(new String[]{
                "Netflix", "Disney+", "Prime Video"
        });

        cbTipoPlan = new JComboBox<>(new String[]{
                "Básico", "Estándar", "Premium"
        });

        spPantallas = new JSpinner(new SpinnerNumberModel(1, 1, 6, 1));

        slCalidad = new JSlider(1, 3, 1);
        slCalidad.setMajorTickSpacing(1);
        slCalidad.setPaintTicks(true);
        slCalidad.setPaintLabels(true);
        slCalidad.setSnapToTicks(true);

        chkSinAnuncios = new JCheckBox("Sin anuncios (+$2000)");
        chkDescargas = new JCheckBox("Descargas offline (+$1000)");
        chkDeportes = new JCheckBox("Deportes (+$3000)");

        listModelPacks = new DefaultListModel<>();
        listModelPacks.addElement("Kids Pack (+$800)");
        listModelPacks.addElement("Cine Premium (+$2000)");
        listModelPacks.addElement("Música (+$1200)");
        listModelPacks.addElement("Familiar (+$1500)");

        listPacks = new JList<>(listModelPacks);
        listPacks.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        txtResumen = new JTextArea(10, 25);
        txtResumen.setEditable(false);

        btnCalcular = new JButton("Calcular Total");
    }

    private void construirLayout() {

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));

        panelFormulario.setBorder(BorderFactory.createTitledBorder("Configuración del Plan"));

        JPanel filaNombre = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filaNombre.add(new JLabel("Cliente: "));
        filaNombre.add(txtNombreCliente);

        JPanel filaPlataforma = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filaPlataforma.add(new JLabel("Plataforma: "));
        filaPlataforma.add(cbPlataforma);

        JPanel filaPlan = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filaPlan.add(new JLabel("Tipo Plan: "));
        filaPlan.add(cbTipoPlan);

        JPanel filaPantallas = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filaPantallas.add(new JLabel("Pantallas: "));
        filaPantallas.add(spPantallas);

        JPanel filaCalidad = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filaCalidad.add(new JLabel("Calidad: "));
        filaCalidad.add(slCalidad);

        JPanel filaChecks = new JPanel();
        filaChecks.setLayout(new BoxLayout(filaChecks, BoxLayout.Y_AXIS));
        filaChecks.setBorder(BorderFactory.createTitledBorder("Extras (Checkbox)"));
        filaChecks.add(chkSinAnuncios);
        filaChecks.add(chkDescargas);
        filaChecks.add(chkDeportes);

        JPanel filaLista = new JPanel(new BorderLayout());
        filaLista.setBorder(BorderFactory.createTitledBorder("Packs (JList)"));
        filaLista.add(new JScrollPane(listPacks), BorderLayout.CENTER);

        panelFormulario.add(filaNombre);
        panelFormulario.add(filaPlataforma);
        panelFormulario.add(filaPlan);
        panelFormulario.add(filaPantallas);
        panelFormulario.add(filaCalidad);
        panelFormulario.add(filaChecks);
        panelFormulario.add(filaLista);

        JPanel panelResultado = new JPanel(new BorderLayout());
        panelResultado.setBorder(BorderFactory.createTitledBorder("Boleta / Resumen"));

        panelResultado.add(new JScrollPane(txtResumen), BorderLayout.CENTER);
        panelResultado.add(btnCalcular, BorderLayout.SOUTH);

        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);
        panelPrincipal.add(panelResultado, BorderLayout.EAST);

        setContentPane(panelPrincipal);
    }

    private void configurarEventos() {

        btnCalcular.addActionListener(e -> calcularYMostrar());

//        cbPlataforma.addActionListener(e -> calcularYMostrar());
//        cbTipoPlan.addActionListener(e -> calcularYMostrar());
//
//        chkSinAnuncios.addActionListener(e -> calcularYMostrar());
//        chkDescargas.addActionListener(e -> calcularYMostrar());
//        chkDeportes.addActionListener(e -> calcularYMostrar());
//
//        listPacks.addListSelectionListener(e -> {
//            if (!e.getValueIsAdjusting()) {
//                calcularYMostrar();
//            }
//        });
//
//        slCalidad.addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                calcularYMostrar();
//            }
//        });
//
//        spPantallas.addChangeListener(e -> calcularYMostrar());
    }

    private void calcularYMostrar() {

        String nombre = txtNombreCliente.getText().trim();
        String plataforma = (String) cbPlataforma.getSelectedItem();
        String tipoPlan = (String) cbTipoPlan.getSelectedItem();

        int pantallas = (int) spPantallas.getValue();
        int calidad = slCalidad.getValue(); // 1 SD, 2 HD, 3 4K

        List<String> extras = new ArrayList<>();
        if (chkSinAnuncios.isSelected()) extras.add("Sin anuncios");
        if (chkDescargas.isSelected()) extras.add("Descargas offline");
        if (chkDeportes.isSelected()) extras.add("Deportes");

        List<String> packs = new ArrayList<>();
        for (String s : listPacks.getSelectedValuesList()) {
            String limpio = s.split("\\(")[0].trim();
            packs.add(limpio);
        }

        PlanStreaming plan = new PlanStreaming(
                nombre,
                plataforma,
                tipoPlan,
                pantallas,
                calidad,
                extras,
                packs
        );

        int total = sistema.calcularTotal(plan);

        txtResumen.setText("");
        txtResumen.append("Cliente: " + (nombre.isEmpty() ? "(sin nombre)" : nombre) + "\n");
        txtResumen.append("Plataforma: " + plataforma + "\n");
        txtResumen.append("Plan: " + tipoPlan + "\n");
        txtResumen.append("Pantallas: " + pantallas + "\n");
        txtResumen.append("Calidad: " + convertirCalidadTexto(calidad) + "\n");
        txtResumen.append("\n--- Extras Checkbox ---\n");
        txtResumen.append(extras.isEmpty() ? "(ninguno)\n" : String.join(", ", extras) + "\n");
        txtResumen.append("\n--- Packs Seleccionados ---\n");
        txtResumen.append(packs.isEmpty() ? "(ninguno)\n" : String.join(", ", packs) + "\n");
        txtResumen.append("\n========================\n");
        txtResumen.append("TOTAL: $" + total + " CLP\n");
    }

    private String convertirCalidadTexto(int calidad) {
        switch (calidad) {
            case 1: return "SD";
            case 2: return "HD";
            case 3: return "4K";
            default: return "Desconocida";
        }
    }
}

