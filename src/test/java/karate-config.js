function fn() {
    var env = karate.env; // obtém a system property 'karate.env'
    var config = { env: env }
    var headers = { "cache-control": "no-cache"}
    var domain = karate.read('classpath:projeto/domain/config.yaml')
    karate.configure('ssl', true)

    if (!env) {
        env = 'qa'; // default
    }

    // Seleção de ambientes com switch-case
    switch (env) {
        case 'dev':
            // Lê config.yaml da pasta domain
            config = karate.read('classpath:projeto/domain/config.yaml')['dev'];
            break;

        case 'qa':
            config = karate.read('classpath:projeto/domain/config.yaml')['qa'];
            break;
    }

    //recuperar ambiente
    karate.log('karate.env system property was:', env);

    // Configuração de retry
    karate.configure('retry', { count: 3, interval: 2000 });

    //Configuracao headers
    karate.configure('headers', headers);

    return config;
}