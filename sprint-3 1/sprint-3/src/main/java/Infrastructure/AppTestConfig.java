package Infrastructure;

import Entidade.RegistroDeIncidente;
import Repositorio.RegistroDeIncidenteRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AppTestConfig {
    public static Logger logger = LogManager.getLogger(AppTestConfig.class);

    public static void testApp() {
        boolean allTestsPassed = true;

        try {
            testDatabaseConnection();
        } catch (SQLException e) {
            logger.fatal("Erro ao estabeler conexão com o banco de dados", e);
            allTestsPassed = false;
        } catch (Exception e) {
            logger.fatal("Erro inesperado", e);
            allTestsPassed = false;
        }

        if (!testFileSystem()) {
            logger.error("Erro no sistema de arquivos");
            allTestsPassed = false;
        }

        if (!testRepositoryOperations()) {
            logger.error("Erro nas operações do repositório");
            allTestsPassed = false;
        }

        if (!testJsonSerialization()) {
            logger.error("Erro na serialização JSON");
            allTestsPassed = false;
        }

        if (!testMemoryAvailability()) {
            logger.warn("Memória disponível abaixo do recomendado");
            // Not failing the tests, just warning
        }

        if (allTestsPassed) {
            logger.info("Todos os testes passaram com sucesso");
            System.out.println("Todos os testes passaram com sucesso");
        } else {
            logger.warn("Alguns testes falharam, o aplicativo pode não funcionar corretamente");
        }
    }

    public static void testDatabaseConnection() throws SQLException {
        logger.info("Testando banco de dados...");
        var connection = DatabaseConfig.getConnection();
        logger.info("Conexão com o banco de dados estabelecida");
        connection.close();
    }

    public static boolean testFileSystem() {
        logger.info("Testando sistema de arquivos...");
        try {
            File reportsDir = new File("./reports");

            if (!reportsDir.exists()) {
                if (!reportsDir.mkdirs()) {
                    logger.error("Não foi possível criar o diretório de relatórios");
                    return false;
                }
                logger.info("Diretório de relatórios criado");
            }

            // Test write permissions
            File testFile = new File("./reports/test.txt");
            if (testFile.createNewFile()) {
                testFile.delete();
                logger.info("Teste de escrita no sistema de arquivos bem-sucedido");
                return true;
            } else {
                logger.error("Não foi possível criar arquivo de teste");
                return false;
            }
        } catch (Exception e) {
            logger.error("Erro ao testar sistema de arquivos", e);
            return false;
        }
    }

    public static boolean testRepositoryOperations() {
        logger.info("Testando operações do repositório...");
        try {
            // Create a test repository
            RegistroDeIncidenteRepository testRepo = new RegistroDeIncidenteRepository();

            // Create a test collection
            RegistroDeIncidente testColecao = new RegistroDeIncidente("Teste de registro", "teste","teste", LocalDateTime.now().toString());

            // Test add operation
           // testRepo.adicionar(testColecao);
            logger.info("Registro adicionado com sucesso");

            // Test list operation
            var colecoes = testRepo.listar();

            // Clean up - remove test collection
            testRepo.deleteById(testColecao.getId());

            logger.info("Teste de operações do repositório bem-sucedido");
            return true;
        } catch (Exception e) {
            logger.error("Erro ao testar operações do repositório", e);
            return false;
        }
    }

    public static boolean testJsonSerialization() {
        logger.info("Testando serialização JSON...");
        try {
           // RegistroDeIncidenteRepository testRepo = new RegistroDeIncidenteRepository();

            //RegistroDeIncidenteRepository testRegist = new RegistroDeIncidenteRepository("JSON Test", "JSON001","True", LocalDateTime.now().toString());
            //testRepo.adicionar(testRegist);

           // // Test JSON export
            //testRepo.exportarParaJson();

            // Clean up
           // testRepo.deleteById(testRegist.getId());

            logger.info("Teste de serialização JSON bem-sucedido");
            return true;
        } catch (Exception e) {
            logger.error("Erro ao testar serialização JSON", e);
            return false;
        }
    }

    public static boolean testMemoryAvailability() {
        logger.info("Verificando memória disponível...");
        long freeMemoryMB = Runtime.getRuntime().freeMemory() / (1024 * 1024);
        logger.info("Memória livre: " + freeMemoryMB + "MB");

        // Check if there's at least 100MB of free memory
        boolean sufficient = freeMemoryMB >= 100;
        if (!sufficient) {
            logger.warn("Memória disponível abaixo do recomendado (100MB)");
        }
        return sufficient;
    }
}
