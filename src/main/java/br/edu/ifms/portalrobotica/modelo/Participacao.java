package br.edu.ifms.portalrobotica.modelo;

public class Participacao {

    private int atividadeId;
    private int estudanteId;
    private String funcao;
    private String descricaoContribuicao;
    private Estudante estudante;
    private Atividade atividade;

    public Participacao() {
    }

    public Participacao(int atividadeId, int estudanteId, String funcao, String descricaoContribuicao, Estudante estudante, Atividade atividade) {
        this.atividadeId = atividadeId;
        this.estudanteId = estudanteId;
        this.funcao = funcao;
        this.descricaoContribuicao = descricaoContribuicao;
        this.estudante = estudante;
        this.atividade = atividade;
    }

    public Participacao(int atividadeId, int estudanteId, String funcao, String descricaoContribuicao) {
        this.atividadeId = atividadeId;
        this.estudanteId = estudanteId;
        this.funcao = funcao;
        this.descricaoContribuicao = descricaoContribuicao;
    }

    @Override
    public String toString() {
        return "Participacao [estudanteId=" + estudanteId
                + ", atividadeId=" + atividadeId
                + ", funcao=" + funcao
                + ", descricaoContribuicao=" + descricaoContribuicao + "]";
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getDescricaoContribuicao() {
        return descricaoContribuicao;
    }

    public void setDescricaoContribuicao(String descricaoContribuicao) {
        this.descricaoContribuicao = descricaoContribuicao;
    }

    public int getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(int atividadeId) {
        this.atividadeId = atividadeId;
    }

    public int getEstudanteId() {
        return estudanteId;
    }

    public void setEstudanteId(int estudanteId) {
        this.estudanteId = estudanteId;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

}
