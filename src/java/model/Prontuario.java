package model;

public class Prontuario {

    private int id;
    private int Paciente_id;
    private String diagnostico;
    private String tratamento;
    private String observacoes;
    private String data_Registro;
    private String pacienteNome;

    public Prontuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaciente_id() {
        return Paciente_id;
    }

    public void setPaciente_id(int Paciente_id) {
        this.Paciente_id = Paciente_id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getData_registro() {
        return data_Registro;
    }

    public void setData_registro(String data_registro) {
        this.data_Registro = data_registro;
    }

    public String getPacienteNome() {
        return pacienteNome;
    }

    public void setPacienteNome(String pacienteNome) {
        this.pacienteNome = pacienteNome;
    }

    @Override
    public String toString() {
        return "Prontuario{" +
                "id=" + id +
                ", paciente_id=" + Paciente_id +
                ", diagnostico='" + diagnostico + '\'' +
                ", tratamento='" + tratamento + '\'' +
                ", observacoes='" + observacoes + '\'' +
                ", data_registro='" + data_Registro + '\'' +
                ", pacienteNome='" + pacienteNome + '\'' +
                '}';
    }
}