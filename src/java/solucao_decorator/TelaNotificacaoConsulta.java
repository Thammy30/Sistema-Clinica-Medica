package solucao_decorator;

import javax.swing.*;
import java.awt.*;

public class TelaNotificacaoConsulta extends JFrame {
    // Componentes da Tela
    private JTextField txtIdPaciente = new JTextField(10);
    private JCheckBox chkSms = new JCheckBox("Enviar SMS");
    private JCheckBox chkWhatsApp = new JCheckBox("Enviar WhatsApp");
    private JButton btnEnviar = new JButton("Enviar Notificações");

    public TelaNotificacaoConsulta() {
        setTitle("Notificações de Consulta");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Adicionando componentes
        add(new JLabel("ID do Paciente:"));
        add(txtIdPaciente);
        add(chkSms);
        add(chkWhatsApp);
        add(btnEnviar);

        // Ação do botão
        btnEnviar.addActionListener(e -> enviarNotificacao());
    }

    private void enviarNotificacao() {
        // O EmailNotificacao é a base obrigatória
        Notificacao notif = new EmailNotificacao();

        // Decora conforme o que foi marcado na tela
        if (chkSms.isSelected()) {
            notif = new SmsDecorator(notif);
        }
        if (chkWhatsApp.isSelected()) {
            notif = new WhatsAppDecorator(notif);
        }

        // Executa a "pilha" de notificações
        notif.enviar("Consulta Agendada!", "Paciente ID: " + txtIdPaciente.getText());
        
        JOptionPane.showMessageDialog(this, "Notificação enviada com sucesso!");
    }

    public static void main(String[] args) {
        new TelaNotificacaoConsulta().setVisible(true);
    }
}