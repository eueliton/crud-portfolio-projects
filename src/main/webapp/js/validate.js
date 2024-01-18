function validarPessoa() {
    var msgErro = "";
    var nome = $('#nome').val();
    var datanascimento = $('#datanascimento').val();
    var cpf = $('#cpf').val();

    if (nome == "") {
        msgErro = msgErro + '- Preencha o campo com seu nome.  </br>';
    }

    if (datanascimento == "" || datanascimento.length < 10 || validaData (datanascimento) == false) {
        msgErro = msgErro + '- Preencha a data de nascimento com valor válido. </br>';
    }

    if (cpf == "" || validarCPF(cpf) == false) {
        msgErro = msgErro + '- Preencha o CPF com valor válido. </br>';
    }



    if(msgErro != ""){
        Command: toastr["error"]( msgErro)
        return false;
    }


}

function validarProjeto() {
    var msgErro = "";
    var nome = $('#nome').val();
    var data_inicio = $('#data_inicio').val();
    var data_fim = $('#data_fim').val();
    var data_previsao_fim = $('#data_previsao_fim').val();
    var status = $('#status').val();
    var risco = $('#risco').val();
    var gerente = $('#gerente').val();
    var orcamento = $('#orcamento').val().replace(/[,.]/g, m => (m === ',' ? '.' : ''))
    $('#orcamento').prop("value", orcamento);

    if (nome == "") {
        msgErro = msgErro + '- Preencha o campo nome.  </br>';
    }

    if (validaData (data_inicio) == false) {
        msgErro = msgErro + '- Preencha a data de início com valor válido. </br>';
    }

    if (validaData (data_previsao_fim) == false) {
        msgErro = msgErro + '- Preencha a data de previsão do fim com valor válido. </br>';
    }

    if (validaData (data_fim) == false) {
        msgErro = msgErro + '- Preencha a data do fim com valor válido. </br>';
    }

    if (status == "") {
        msgErro = msgErro + '- Preencha o campo status.  </br>';
    }
    if (risco == "") {
        msgErro = msgErro + '- Preencha o campo risco.  </br>';
    }
    if (gerente == "") {
        msgErro = msgErro + '- Preencha o campo gerente.  </br>';
    }

    if(msgErro != ""){
        Command: toastr["error"]( msgErro)
        return false;
    }


}


function validaData (valor) {
    if (typeof valor !== 'string') {
        return false
    }

    if (!/^\d{2}\/\d{2}\/\d{4}$/.test(valor)) {
        return false
    }

    const partesData = valor.split('/')
    const data = {
        dia: partesData[0],
        mes: partesData[1],
        ano: partesData[2]
    }

    const dia = parseInt(data.dia)
    const mes = parseInt(data.mes)
    const ano = parseInt(data.ano)

    const diasNoMes = [ 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ]

    if (ano % 400 === 0 || ano % 4 === 0 && ano % 100 !== 0) {
        diasNoMes[2] = 29
    }


    if (mes < 1 || mes > 12 || dia < 1) {
        return false
    }
    else if (dia > diasNoMes[mes]) {
        return false
    }


    return true
}


function validarCPF(cpf) {
    var cpfRegex = /^(?:(\d{3}).(\d{3}).(\d{3})-(\d{2}))$/;
    if (!cpfRegex.test(cpf)) {
        return false;
    }

    var numeros = cpf.match(/\d/g).map(Number);
    var soma = numeros.reduce((acc, cur, idx) => {
        if (idx < 9) {
            return acc + cur * (10 - idx);
        }
        return acc;
    }, 0);

    var resto = (soma * 10) % 11;

    if (resto === 10 || resto === 11) {
        resto = 0;
    }

    if (resto !== numeros[9]) {
        return false;
    }

    soma = numeros.reduce((acc, cur, idx) => {
        if (idx < 10) {
            return acc + cur * (11 - idx);
        }
        return acc;
    }, 0);

    resto = (soma * 10) % 11;

    if (resto === 10 || resto === 11) {
        resto = 0;
    }

    if (resto !== numeros[10]) {
        return false;
    }

    return true;
}