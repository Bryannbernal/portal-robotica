

const secoes = document.querySelectorAll(
        "section[id]"
        );

const links = document.querySelectorAll(
        ".menu-link"
        );

window.addEventListener(
        "scroll",
        function () {

            let secaoAtual = "inicio";

            secoes.forEach(
                    function (secao) {

                        const distancia =
                                secao.offsetTop - 220;

                        if (
                                window.scrollY >= distancia
                                ) {
                            secaoAtual = secao.id;
                        }
                    }
            );

            links.forEach(
                    function (link) {

                        link.classList.remove(
                                "active"
                                );

                        const destino =
                                link.getAttribute("href");

                        if (
                                destino ===
                                "#" + secaoAtual
                                ) {
                            link.classList.add(
                                    "active"
                                    );
                        }
                    }
            );
        }
);

links.forEach(
        function (link) {

            link.addEventListener(
                    "click",
                    function () {

                        const menu =
                                document.getElementById(
                                        "menuPrincipal"
                                        );

                        if (
                                menu.classList.contains(
                                        "show"
                                        )
                                ) {

                            const instancia =
                                    bootstrap.Collapse
                                    .getInstance(menu);

                            if (instancia) {
                                instancia.hide();
                            }
                        }
                    }
            );
        }
);