/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import DAO.INVENTARIO;
import DAO.INVENTARIO_DAO;
import crud_admon.Inventario;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guillermo Mata
 */
public class ControladorInventario implements ActionListener{

    INVENTARIO inventario = new INVENTARIO();
    INVENTARIO_DAO inventario_obj = new INVENTARIO_DAO();
    Inventario InventarioVista = new Inventario();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    //variables globales 
    private int id;
    private String NombreCorto;
    private String Descripcion;
    private String Serie;
    private String Color;
    private String Fecha_Adquision;
    private String Tipo_Adquision;
    private String Observaciones;

    public ControladorInventario(Inventario vista) {
        this.InventarioVista = vista;
        vista.setVisible(true);
         agregarEvento();
         ListarTabla();

    }

    public void agregarEvento() {
        InventarioVista.getBtnAgregarInventario().addActionListener(this);
        InventarioVista.getBtnActualizarInventario().addActionListener(this);
        InventarioVista.getBtnEliminarInventario().addActionListener(this);
        InventarioVista.getBtnLimpiarInventario().addActionListener(this);
        
        InventarioVista.getTblInventario().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LlenarCampos(e);
            }
        });
    }

    private void ListarTabla() {
        String[] titulos = new String[]{"Id", "NombreCorto", "Descripción", "Serie", "Color", "FechaAdquision", "TipoAdquision", "Observaciones"};
        modeloTabla = new DefaultTableModel(titulos, 0);
        List<INVENTARIO> listainventario = inventario_obj.listar();
        for (INVENTARIO inventario : listainventario) {
            modeloTabla.addRow(new Object[]{inventario.getId(), inventario.getNombreCorto(), inventario.getDescripcion(), inventario.getSerie(), inventario.getColor(), inventario.getFecha_Adquision(), inventario.getTipo_Adquision(), inventario.getObservaciones()});
        }
        InventarioVista.getTblInventario().setModel(modeloTabla);
        InventarioVista.getTblInventario().setPreferredSize(new Dimension(950, modeloTabla.getRowCount() * 19));

    }

    private void LlenarCampos(MouseEvent e) { // esas madres son para la vista con lectura pa q se vea mamalon
        JTable target = (JTable) e.getSource();
        id = (int) InventarioVista.getTblInventario().getModel().getValueAt(target.getSelectedRow(), 0);
        InventarioVista.getTxtNombre().setText(InventarioVista.getTblInventario().getModel().getValueAt(target.getSelectedRow(), 1).toString());
        InventarioVista.getTxtDescripcion().setText(InventarioVista.getTblInventario().getModel().getValueAt(target.getSelectedRow(), 2).toString());
        InventarioVista.getTxtSerie().setText(InventarioVista.getTblInventario().getModel().getValueAt(target.getSelectedRow(), 3).toString());
        InventarioVista.getTxtColor().setText(InventarioVista.getTblInventario().getModel().getValueAt(target.getSelectedRow(), 4).toString());
        InventarioVista.getTxtFecha().setText(InventarioVista.getTblInventario().getModel().getValueAt(target.getSelectedRow(), 5).toString());
        InventarioVista.getTxtTipoAD().setText(InventarioVista.getTblInventario().getModel().getValueAt(target.getSelectedRow(), 6).toString());
        InventarioVista.getTxtObservaciones().setText(InventarioVista.getTblInventario().getModel().getValueAt(target.getSelectedRow(), 7).toString());
    }

    private boolean ValidarDatos() {
        if ("".equals(InventarioVista.getTxtNombre().getText()) || "".equals(InventarioVista.getTxtDescripcion().getText()) || "".equals(InventarioVista.getTxtSerie().getText())
                || "".equals(InventarioVista.getTxtColor().getText()) || "".equals(InventarioVista.getTxtFecha().getText()) || "".equals(InventarioVista.getTxtTipoAD().getText())
                || "".equals(InventarioVista.getTxtObservaciones().getText())) {
            JOptionPane.showMessageDialog(null, "Los campos no pueden ser vacios wuey!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
      private boolean CargarDatos() {
        try {
            NombreCorto = InventarioVista.getTxtNombre().getText();
            Descripcion = InventarioVista.getTxtDescripcion().getText();
            Serie = InventarioVista.getTxtSerie().getText();
            Color = InventarioVista.getTxtColor().getText();
            Fecha_Adquision = InventarioVista.getTxtFecha().getText();
            Tipo_Adquision = InventarioVista.getTxtTipoAD().getText();
            Observaciones = InventarioVista.getTxtObservaciones().getText();
             
            return true;
        } catch (Exception e) {
            System.out.println("Error al cargar datos" + e);
        }
        return false;
    }

      private boolean LimpiarDatos() {
        
        InventarioVista.getTxtNombre().setText("");
        InventarioVista.getTxtColor().setText("");
        InventarioVista.getTxtDescripcion().setText("");
        InventarioVista.getTxtSerie().setText("");
        InventarioVista.getTxtFecha().setText("");
        InventarioVista.getTxtTipoAD().setText("");
        InventarioVista.getTxtObservaciones().setText("");
        
        id=0;
        NombreCorto="";
        Color="";
        Descripcion="";
        Serie="";
        Fecha_Adquision="";
        Tipo_Adquision="";
        Observaciones="";
        
        
        return false;
    }
      
      private boolean Agregar() {
        try {
            if (ValidarDatos()) {
                if (CargarDatos()) {
                    INVENTARIO inventario = new INVENTARIO(NombreCorto, Descripcion, Serie, Color, Fecha_Adquision, Tipo_Adquision, Observaciones);
                    inventario_obj.agregar(inventario);
                    JOptionPane.showMessageDialog(null, "¡Registro exitoso!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Los campos no deben de ser numericoS", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al agregar: " + e);
        } finally {
            ListarTabla();
        }
        return false;
    }
      private boolean actualizar() {
        try {
            if (ValidarDatos()) {
                if (CargarDatos()) {
                    INVENTARIO inventario = new INVENTARIO(id, NombreCorto, Descripcion, Serie, Color, Fecha_Adquision, Tipo_Adquision, Observaciones);
                    inventario_obj.actualizar(inventario);
                    JOptionPane.showMessageDialog(null, "Registro Actualizado");
                    LimpiarDatos();
                }
            }
        } catch (Exception e) {
            System.out.println("Error en la actualizacion de producto " + e);
        } finally {
            ListarTabla();
        }
        return false;
    }
      
      private void borrar() {
        try {
            if (id != 0) {
                inventario_obj.borrar(id);
                JOptionPane.showMessageDialog(null, "Registro Eliminados");
                LimpiarDatos();
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Se debe de seleccionar un producto para ser eliminado", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ListarTabla();
        }
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == InventarioVista.getBtnAgregarInventario()) {
            Agregar();
        }
        if (ae.getSource() == InventarioVista.getBtnActualizarInventario()) {
            actualizar();
        }
        if (ae.getSource() == InventarioVista.getBtnEliminarInventario()) {
            borrar();
        }
        if (ae.getSource() == InventarioVista.getBtnLimpiarInventario()) {
            LimpiarDatos();

        }
    }
}
