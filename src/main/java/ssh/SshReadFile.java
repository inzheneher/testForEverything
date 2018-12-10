package ssh;

import com.jcraft.jsch.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class SshReadFile {

    private static String user;
    private static String pass;
    private static String host;
    private static int port;
    private static String remoteFile;

    public SshReadFile() {
        Properties prop = new Properties();
        try (InputStream inputStream = new FileInputStream("src/main/resources/host.properties")) {
            prop.load(inputStream);
            user = prop.getProperty("user");
            pass = prop.getProperty("pass");
            host = prop.getProperty("host");
            port = Integer.valueOf(prop.getProperty("port"));
            remoteFile = prop.getProperty("remoteFile");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        SshReadFile sshReadFile = new SshReadFile();

        try {
            JSch jSch = new JSch();
            jSch.setKnownHosts(System.getProperty("user.home") + "/.ssh/known_hosts");
            Session session = jSch.getSession(user, host, port);
            session.setPassword(pass);
            session.connect(10000);
            ChannelSftp sftp = (ChannelSftp) session.openChannel("sftp");
            sftp.connect();
            List list = sftp.ls("/home/inzheneher/Documents/");

            for (Object o : list) {
                System.out.println(o.toString());
            }

            InputStream inputStream = sftp.get(remoteFile);
            try (Scanner scanner = new Scanner(new InputStreamReader(inputStream))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            }
            session.disconnect();
        } catch (JSchException | SftpException e) {
            e.printStackTrace();
        }
    }
}
