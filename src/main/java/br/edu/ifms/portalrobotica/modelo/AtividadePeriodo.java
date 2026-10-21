package br.edu.ifms.portalrobotica.modelo;

// Esse modelo é da tabela atividade_periodo
public class AtividadePeriodo {

    private int atividadeId;
    private int periodoId;
    private Atividade atividade;
    private Periodo periodo;

    public AtividadePeriodo() {
    }

    public AtividadePeriodo(int atividade_id, int periodo_id) {
        this.atividadeId = atividade_id;
        this.periodoId = periodo_id;
    }

    @Override
    public String toString() {
        return "AtividadePeriodo [atividadeId=" + atividadeId
                + ", periodoId=" + periodoId + "]";
    }

    public int getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(int atividadeId) {
        this.atividadeId = atividadeId;
    }

    public int getPeriodoId() {
        return periodoId;
    }

    public void setPeriodoId(int periodoId) {
        this.periodoId = periodoId;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

}
