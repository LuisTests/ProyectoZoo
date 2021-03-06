/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

import modelo.Reloj;
import modelo.Slide;
import vista.HistorialActividades;
import vista.Home;
import vista.RegistroAnimales;
import vista.*;

/**
 *
 * @author beatl
 */
public class ctrlMenu implements ActionListener, MouseListener {
    private menu m;
    private Color verdeOn;
    private Color verdePrincipal;
    private Font fontClick;
    private Font fontNormal;
    private Slide sl ;
    private Reloj r;
    private boolean stop = false;
    
    
    
    private ctrlHistorialActividades ctrlHA;
    private ctrlHistorialHabitats ctrlHH;
    private ctrlHistorialVisitas ctrlHV;
    private ctrlPersonalAnimales ctrlPA;
    private ctrlPersonalCuidadores ctrlPC;
    private ctrlPersonalVeterinarios ctrlPV;
    private ctrlRegistroActividades ctrlRA;
    private ctrlRegistroAnimales ctrlRAni;
    private ctrlRegistroCuidadores ctrlRC;
    private ctrlRegistroVeterinarios ctrlRV;
    private ctrlReporteHabitats ctrlRH;
    private ctrlReporteVisitaMedica ctrlRVM;
    private ctrlHome ctrlH;
    
    private Home h;
    private HistorialActividades ha;
    private HistorialHabitats hh;
    private HistorialVisitas hv;
    private PersonalAnimales pa;
    private PersonalCuidadores pc;
    private PersonalVeterinarios pv;
    private RegistroActividades ra;
    private RegistroAnimales rani;
    private RegistroCuidadores rc;
    private RegistroVeterinarios rv;
    private ReporteHabitats rh;
    private ReporteVisitaMedica rvm;
    
    public ctrlMenu(menu m) {
        this.m = m;
        
        iniComponents();
        
 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == m.btnClose) {
            m.setVisible(false);
            m.dispose();
            ctrlH.getR().setCerrar(false);

        } else if (e.getSource() == m.btnMinimize) {
            m.setExtendedState(ICONIFIED);
        } else if (e.getSource() == m.btnHome) {
            m.pnlMainMenu.removeAll();
            m.pnlMainMenu.add(h);
            m.pnlMainMenu.repaint();
            m.pnlMainMenu.revalidate();
            

        } else if (e.getSource() == m.btnRegistroVeterinario) {
            setPanel(rv);
        } else if (e.getSource() == m.btnRegistroCuidador) {
            setPanel(rc);
        } else if (e.getSource() == m.btnRegistroAnimales) {
            setPanel(rani);
        }else if(e.getSource() == m.btnRegistroActividades){
            setPanel(ra);
        }else if(e.getSource() == m.btnReporteVisitaMedica){
            setPanel(rvm);
        }else if(e.getSource() == m.btnReporteHabitat){
            setPanel(rh);
        }else if(e.getSource() == m.btnHistorialVisitas){
            setPanel(hv);
        }else if(e.getSource() == m.btnHistorialHabitats){
            setPanel(hh);
        }else if(e.getSource() == m.btnHistorialActividades){
            setPanel(ha);
        }else if(e.getSource() == m.btnPersonalAnimales){
            setPanel(pa);
        }else if(e.getSource() == m.btnPersonalCuidadores){
            setPanel(pc);
        }else if(e.getSource() == m.btnPersonalVeterinarios){
            setPanel(pv);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == m.btnRegistroVeterinario) {
            m.btnRegistroVeterinario.setFont(fontClick);
        } else if (e.getSource() == m.btnRegistroCuidador) {
            m.btnRegistroCuidador.setFont(fontClick);
        } else if (e.getSource() == m.btnRegistroAnimales) {
            m.btnRegistroAnimales.setFont(fontClick);
        }else if(e.getSource() == m.btnRegistroActividades){
            m.btnRegistroActividades.setFont(fontClick);
        }else if(e.getSource() == m.btnReporteVisitaMedica){
            m.btnReporteVisitaMedica.setFont(fontClick);
        }else if(e.getSource() == m.btnReporteHabitat){
            m.btnReporteHabitat.setFont(fontClick);
        }else if(e.getSource() == m.btnHistorialVisitas){
            m.btnHistorialVisitas.setFont(fontClick);
        }else if(e.getSource() == m.btnHistorialHabitats){
            m.btnHistorialHabitats.setFont(fontClick);
        }else if(e.getSource() == m.btnHistorialActividades){
            m.btnHistorialActividades.setFont(fontClick);
        }else if(e.getSource() == m.btnPersonalAnimales){
            m.btnPersonalAnimales.setFont(fontClick);
        }else if(e.getSource() == m.btnPersonalCuidadores){
            m.btnPersonalCuidadores.setFont(fontClick);
        }else if(e.getSource() == m.btnPersonalVeterinarios){
            m.btnPersonalVeterinarios.setFont(fontClick);
        }else if(e.getSource() == m.lblBuscar){
            m.lblBuscar.setText(null);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == m.btnRegistroVeterinario) {
            m.btnRegistroVeterinario.setFont(fontNormal);
        } else if (e.getSource() == m.btnRegistroCuidador) {
            m.btnRegistroCuidador.setFont(fontNormal);
        } else if (e.getSource() == m.btnRegistroAnimales) {
            m.btnRegistroAnimales.setFont(fontNormal);
        }else if(e.getSource() == m.btnRegistroActividades){
            m.btnRegistroActividades.setFont(fontNormal);
        }else if(e.getSource() == m.btnReporteVisitaMedica){
            m.btnReporteVisitaMedica.setFont(fontNormal);
        }else if(e.getSource() == m.btnReporteHabitat){
            m.btnReporteHabitat.setFont(fontNormal);
        }else if(e.getSource() == m.btnHistorialVisitas){
            m.btnHistorialVisitas.setFont(fontNormal);
        }else if(e.getSource() == m.btnHistorialHabitats){
            m.btnHistorialHabitats.setFont(fontNormal);
        }else if(e.getSource() == m.btnHistorialActividades){
            m.btnHistorialActividades.setFont(fontNormal);
        }else if(e.getSource() == m.btnPersonalAnimales){
            m.btnPersonalAnimales.setFont(fontNormal);
        }else if(e.getSource() == m.btnPersonalCuidadores){
            m.btnPersonalCuidadores.setFont(fontNormal);
        }else if(e.getSource() == m.btnPersonalVeterinarios){
            m.btnPersonalVeterinarios.setFont(fontNormal);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()== m.btnHome){
            m.btnHome.setBackground(verdeOn);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()== m.btnHome){
            m.btnHome.setBackground(verdePrincipal);
        }
    }

    
    private void setPanel(JPanel panel) {
        m.pnlMainMenu.removeAll();
        m.pnlMainMenu.add(panel);
        m.pnlMainMenu.repaint();
        m.pnlMainMenu.revalidate();
    }
   
   
    private void iniComponents() {
        this.m.btnMinimize.addActionListener(this);
        this.m.btnMinimize.addMouseListener(this);

        this.m.btnClose.addMouseListener(this);
        this.m.btnClose.addActionListener(this);

        this.m.btnHome.addActionListener(this);
        this.m.btnHistorialActividades.addActionListener(this);
        this.m.btnHistorialHabitats.addActionListener(this);
        this.m.btnHistorialVisitas.addActionListener(this);
        this.m.btnPersonalAnimales.addActionListener(this);
        this.m.btnPersonalCuidadores.addActionListener(this);
        this.m.btnPersonalVeterinarios.addActionListener(this);
        this.m.btnRegistroActividades.addActionListener(this);
        this.m.btnRegistroAnimales.addActionListener(this);
        this.m.btnRegistroCuidador.addActionListener(this);
        this.m.btnRegistroVeterinario.addActionListener(this);
        this.m.btnReporteHabitat.addActionListener(this);
        this.m.btnReporteVisitaMedica.addActionListener(this);

        this.m.btnHome.addMouseListener(this);
        this.m.btnHistorialActividades.addMouseListener(this);
        this.m.btnHistorialHabitats.addMouseListener(this);
        this.m.btnHistorialVisitas.addMouseListener(this);
        this.m.btnPersonalAnimales.addMouseListener(this);
        this.m.btnPersonalCuidadores.addMouseListener(this);
        this.m.btnPersonalVeterinarios.addMouseListener(this);
        this.m.btnRegistroActividades.addMouseListener(this);
        this.m.btnRegistroAnimales.addMouseListener(this);
        this.m.btnRegistroCuidador.addMouseListener(this);
        this.m.btnRegistroVeterinario.addMouseListener(this);
        this.m.btnReporteHabitat.addMouseListener(this);
        this.m.btnReporteVisitaMedica.addMouseListener(this);

        this.h = new Home();
        this.ctrlH = new ctrlHome(h);
        this.ha = new HistorialActividades();
        this.hh = new HistorialHabitats();
        this.hv = new HistorialVisitas();
        this.ra = new RegistroActividades();
        this.rani = new RegistroAnimales();
        this.rc = new RegistroCuidadores();
        this.rv = new RegistroVeterinarios();
        this.rh = new ReporteHabitats();
        this.rvm = new ReporteVisitaMedica();
        this.pa = new PersonalAnimales();
        this.pc = new PersonalCuidadores();
        this.pv = new PersonalVeterinarios();
        
        
        this.ctrlHA = new ctrlHistorialActividades(ha);
        this.ctrlHH = new ctrlHistorialHabitats(hh);
        this.ctrlHV = new ctrlHistorialVisitas(hv);
        this.ctrlRA = new ctrlRegistroActividades(ra);
        this.ctrlRAni = new ctrlRegistroAnimales(rani);
        this.ctrlRC = new ctrlRegistroCuidadores(rc);
        this.ctrlRV = new ctrlRegistroVeterinarios(rv);
        this.ctrlRH = new ctrlReporteHabitats(rh);
        this.ctrlRVM = new ctrlReporteVisitaMedica(rvm);
        this.ctrlPA = new ctrlPersonalAnimales(pa);
        this.ctrlPC = new ctrlPersonalCuidadores(pc);
        this.ctrlPV = new ctrlPersonalVeterinarios(pv);
        

        this.m.lblBuscar.addMouseListener(this);
        
        this.verdeOn = new Color(0, 212, 72);
        this.verdePrincipal = new Color(0, 179, 61);
        this.fontClick = new Font("Segoe UI", Font.PLAIN, 14);
        this.fontNormal = new Font("Segoe UI", Font.PLAIN, 18);

        setPanel(h);

    }
    
    
}
