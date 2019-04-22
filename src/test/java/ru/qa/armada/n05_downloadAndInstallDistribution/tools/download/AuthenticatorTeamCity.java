package ru.qa.armada.n05_downloadAndInstallDistribution.tools.download;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class AuthenticatorTeamCity extends Authenticator {
    private String username = "kamyninsa";
    private String password = "12345";

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username,
                password.toCharArray());
    }
}