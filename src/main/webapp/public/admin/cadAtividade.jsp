```jsp
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="br.edu.ifms.portalrobotica.modelo.Coordenador" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-BR">

    <body>

        <jsp:include page="/public/menu-layout.jsp">
            <jsp:param name="titulo" value="Nova Atividade" />
        </jsp:include>

        <br><br><br><br><br><br>

        <div class="mx-auto p-2" style="width: 800px;">

            <h1>Cadastrar nova atividade</h1>


            <!-- ================================================= -->
            <!-- MENSAGEM DE SUCESSO                               -->
            <!-- ================================================= -->

            <c:if test="${not empty mensagem}">

                <div class="alert alert-success alert-dismissible fade show"
                     role="alert">

                    <strong>Sucesso!</strong>

                    <c:out value="${mensagem}" />

                    <button type="button"
                            class="btn-close"
                            data-bs-dismiss="alert"
                            aria-label="Fechar">
                    </button>

                </div>

            </c:if>


            <!-- ================================================= -->
            <!-- MENSAGEM DE ERRO                                  -->
            <!-- ================================================= -->

            <c:if test="${not empty erro}">

                <div class="alert alert-danger alert-dismissible fade show"
                     role="alert">

                    <strong>Erro:</strong>

                    <c:out value="${erro}" />

                    <button type="button"
                            class="btn-close"
                            data-bs-dismiss="alert"
                            aria-label="Fechar">
                    </button>

                </div>

            </c:if>


            <br>


            <!-- ================================================= -->
            <!-- FORMULÁRIO                                         -->
            <!-- ================================================= -->

            <form
                id="formAtividade"
                method="post"
                enctype="multipart/form-data"
                action="${pageContext.request.contextPath}/admin?acao=inserirAtv">


                <!-- ================================================= -->
                <!-- TÍTULO                                             -->
                <!-- ================================================= -->

                <div class="mb-3">

                    <label class="form-label">
                        Título
                    </label>

                    <input
                        type="text"
                        name="titulo"
                        id="titulo"
                        class="form-control"
                        value="<c:out value='${titulo}'/>"
                        required>

                    <span
                        id="erro-titulo"
                        class="text-danger small">
                    </span>

                </div>


                <!-- ================================================= -->
                <!-- TIPO                                               -->
                <!-- ================================================= -->

                <input
                    type="hidden"
                    id="valor-final"
                    name="tipo"
                    value="<c:out value='${tipo}'/>">


                <label class="form-label">
                    Tipo:
                </label>

                <select
                    class="form-select"
                    id="meu-select"
                    onchange="atualizarValor(this.value)"
                    required>

                    <option value="" selected>
                        Selecione...
                    </option>

                    <option value="oficina">
                        Oficina
                    </option>

                    <option value="evento">
                        Evento
                    </option>

                    <option value="desenvolvimento">
                        Desenvolvimento
                    </option>

                    <option value="competicao">
                        Competição
                    </option>

                    <option value="visita">
                        Visita
                    </option>

                    <option value="estagio">
                        Estágio
                    </option>

                    <option value="palestra">
                        Palestra
                    </option>

                    <option value="outro">
                        Outro
                    </option>

                </select>

                <span
                    id="erro-tipo"
                    class="text-danger small">
                </span>


                <!-- ================================================= -->
                <!-- OUTRO TIPO                                         -->
                <!-- ================================================= -->

                <div
                    id="campo-outro"
                    style="display: none; margin-top: 10px;">

                    <label
                        class="form-label"
                        for="outro-input">

                        Especifique o tipo:

                    </label>

                    <input
                        class="form-control"
                        type="text"
                        id="outro-input"
                        oninput="atualizarValorTexto(this.value)">

                    <span
                        id="erro-outro"
                        class="text-danger small">
                    </span>

                </div>


                <br>


                <!-- ================================================= -->
                <!-- DESCRIÇÃO                                          -->
                <!-- ================================================= -->

                <div class="mb-3">

                    <label class="form-label">
                        Descrição
                    </label>

                    <textarea
                        name="descricao"
                        id="descricao"
                        class="form-control"
                        required><c:out value="${descricao}"/></textarea>

                    <span
                        id="erro-descricao"
                        class="text-danger small">
                    </span>

                </div>


                <!-- ================================================= -->
                <!-- DATA DE INÍCIO                                     -->
                <!-- ================================================= -->

                <div class="mb-3">

                    <label class="form-label">
                        Data de início
                    </label>

                    <input
                        type="date"
                        name="data_inicio"
                        id="data_inicio"
                        class="form-control"
                        value="<c:out value='${data_inicio}'/>"
                        required>

                    <span
                        id="erro-data-inicio"
                        class="text-danger small">
                    </span>

                </div>


                <!-- ================================================= -->
                <!-- ATIVIDADE EM ANDAMENTO                             -->
                <!-- ================================================= -->

                <div class="form-check mb-3">

                    <input
                        class="form-check-input"
                        type="checkbox"
                        id="em_andamento"
                        name="em_andamento"
                        <c:if test="${em_andamento == 'on'}">
                            checked
                        </c:if>
                        >

                    <label
                        class="form-check-label"
                        for="em_andamento">

                        Atividade ainda está ocorrendo

                    </label>

                </div>


                <!-- ================================================= -->
                <!-- DATA DE FIM                                        -->
                <!-- ================================================= -->

                <div class="mb-3">

                    <label class="form-label">
                        Data de fim
                    </label>

                    <input
                        type="date"
                        class="form-control"
                        id="data_fim"
                        name="data_fim"
                        value="<c:out value='${data_fim}'/>">

                    <span
                        id="erro-data-fim"
                        class="text-danger small">
                    </span>

                </div>


                <!-- ================================================= -->
                <!-- SITUAÇÃO                                            -->
                <!-- ================================================= -->

                <div class="mb-3">

                    <label class="form-label">
                        Situação da atividade
                    </label>

                    <select
                        name="situacao"
                        id="situacao"
                        class="form-select"
                        required>

                        <option value="finalizada">
                            Finalizada
                        </option>

                        <option value="acontecendo" selected>
                            Acontecendo
                        </option>

                        <option value="nao iniciada">
                            Não iniciada
                        </option>

                    </select>

                    <span
                        id="erro-situacao"
                        class="text-danger small">
                    </span>

                </div>


                <!-- ================================================= -->
                <!-- COORDENADOR                                        -->
                <!-- ================================================= -->

                <div class="mb-3">

                    <label class="form-label">
                        Coordenador da atividade
                    </label>

                    <select
                        name="coordenador"
                        id="coordenador"
                        class="form-select"
                        required>

                        <option value="">
                            Selecione um coordenador
                        </option>

                        <c:forEach
                            var="coordenadorAtual"
                            items="${coordenadores}">

                            <option
                                value="${coordenadorAtual.id}"
                                <c:if test="${coordenador == coordenadorAtual.id}">
                                    selected
                                </c:if>
                                >

                                <c:out value="${coordenadorAtual.nome}" />

                            </option>

                        </c:forEach>

                    </select>

                    <span
                        id="erro-coordenador"
                        class="text-danger small">
                    </span>

                </div>


                <!-- ================================================= -->
                <!-- BOTÃO                                              -->
                <!-- ================================================= -->

                <button
                    type="submit"
                    class="btn btn-primary">

                    Salvar

                </button>

            </form>

        </div>


        <br><br>


        <jsp:include page="/public/footer-layout.jsp"/>


        <!-- ================================================= -->
        <!-- JAVASCRIPT                                        -->
        <!-- ================================================= -->

        <script>

            /*
             * =====================================================
             * TIPO DA ATIVIDADE
             * =====================================================
             */

            function atualizarValor(valor) {

                const campoOutro =
                        document.getElementById('campo-outro');

                const valorFinal =
                        document.getElementById('valor-final');

                const outroInput =
                        document.getElementById('outro-input');


                if (valor === 'outro') {

                    campoOutro.style.display = 'block';

                    valorFinal.value =
                            outroInput.value;

                } else {

                    campoOutro.style.display = 'none';

                    valorFinal.value =
                            valor;

                    outroInput.value = '';

                }

            }


            function atualizarValorTexto(texto) {

                document.getElementById('valor-final').value =
                        texto;

            }


            /*
             * =====================================================
             * ATIVIDADE SEM DATA DE FIM
             * =====================================================
             */

            document.addEventListener(
                    'DOMContentLoaded',
                    function () {

                        const checkbox =
                                document.getElementById('em_andamento');

                        const dataFim =
                                document.getElementById('data_fim');


                        function atualizarDataFim() {

                            if (checkbox.checked) {

                                dataFim.disabled = true;

                                dataFim.value = '';

                                document.getElementById(
                                        'erro-data-fim'
                                        ).textContent = '';

                            } else {

                                dataFim.disabled = false;

                            }

                        }


                        checkbox.addEventListener(
                                'change',
                                atualizarDataFim
                                );


                        atualizarDataFim();

                    }
            );


            /*
             * =====================================================
             * VALIDAÇÃO DO FORMULÁRIO
             * =====================================================
             */

            document
                    .getElementById('formAtividade')
                    .addEventListener(
                            'submit',
                            function (event) {

                                let valido = true;


                                /*
                                 * Limpa erros anteriores
                                 */

                                document
                                        .querySelectorAll('.text-danger')
                                        .forEach(function (elemento) {

                                            elemento.textContent = '';

                                        });


                                /*
                                 * =================================================
                                 * TÍTULO
                                 * =================================================
                                 */

                                const titulo =
                                        document
                                        .getElementById('titulo')
                                        .value
                                        .trim();


                                if (titulo === '') {

                                    document
                                            .getElementById('erro-titulo')
                                            .textContent =
                                            'Informe o título da atividade.';

                                    valido = false;

                                }


                                /*
                                 * =================================================
                                 * TIPO
                                 * =================================================
                                 */

                                const tipo =
                                        document
                                        .getElementById('valor-final')
                                        .value
                                        .trim();


                                if (tipo === '') {

                                    document
                                            .getElementById('erro-tipo')
                                            .textContent =
                                            'Selecione o tipo da atividade.';

                                    valido = false;

                                }


                                /*
                                 * Se escolheu "Outro"
                                 */

                                const selectTipo =
                                        document
                                        .getElementById('meu-select')
                                        .value;


                                if (
                                        selectTipo === 'outro'
                                        &&
                                        tipo === ''
                                        ) {

                                    document
                                            .getElementById('erro-outro')
                                            .textContent =
                                            'Especifique o tipo da atividade.';

                                    valido = false;

                                }


                                /*
                                 * =================================================
                                 * DESCRIÇÃO
                                 * =================================================
                                 */

                                const descricao =
                                        document
                                        .getElementById('descricao')
                                        .value
                                        .trim();


                                if (descricao === '') {

                                    document
                                            .getElementById('erro-descricao')
                                            .textContent =
                                            'Informe a descrição da atividade.';

                                    valido = false;

                                }


                                /*
                                 * =================================================
                                 * DATAS
                                 * =================================================
                                 */

                                const dataInicio =
                                        document
                                        .getElementById('data_inicio')
                                        .value;


                                const dataFim =
                                        document
                                        .getElementById('data_fim')
                                        .value;


                                const emAndamento =
                                        document
                                        .getElementById('em_andamento')
                                        .checked;


                                /*
                                 * Data inicial obrigatória
                                 */

                                if (dataInicio === '') {

                                    document
                                            .getElementById('erro-data-inicio')
                                            .textContent =
                                            'Informe a data de início.';

                                    valido = false;

                                }


                                /*
                                 * Data final
                                 *
                                 * Se estiver em andamento, a data final
                                 * não precisa ser preenchida.
                                 */

                                if (
                                        !emAndamento
                                        &&
                                        dataFim === ''
                                        ) {

                                    document
                                            .getElementById('erro-data-fim')
                                            .textContent =
                                            'Informe a data de fim ou marque que a atividade ainda está ocorrendo.';

                                    valido = false;

                                }


                                /*
                                 * =================================================
                                 * AQUI ESTÁ A VALIDAÇÃO QUE RESOLVE SEU ERRO
                                 * =================================================
                                 */

                                if (
                                        dataInicio !== ''
                                        &&
                                        dataFim !== ''
                                        &&
                                        dataFim < dataInicio
                                        ) {

                                    document
                                            .getElementById('erro-data-fim')
                                            .textContent =
                                            'A data final não pode ser anterior à data de início.';

                                    valido = false;

                                }


                                /*
                                 * =================================================
                                 * SITUAÇÃO
                                 * =================================================
                                 */

                                const situacao =
                                        document
                                        .getElementById('situacao')
                                        .value;


                                if (situacao === '') {

                                    document
                                            .getElementById('erro-situacao')
                                            .textContent =
                                            'Selecione a situação da atividade.';

                                    valido = false;

                                }


                                /*
                                 * =================================================
                                 * COORDENADOR
                                 * =================================================
                                 */

                                const coordenador =
                                        document
                                        .getElementById('coordenador')
                                        .value;


                                if (coordenador === '') {

                                    document
                                            .getElementById('erro-coordenador')
                                            .textContent =
                                            'Selecione um coordenador.';

                                    valido = false;

                                }


                                /*
                                 * =================================================
                                 * IMPEDE O ENVIO
                                 * =================================================
                                 */

                                if (!valido) {

                                    event.preventDefault();

                                }

                            }
                    );

        </script>


        <script
            src="${pageContext.request.contextPath}/resources/js/script.js">
        </script>


        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
            crossorigin="anonymous">
        </script>

    </body>

</html>