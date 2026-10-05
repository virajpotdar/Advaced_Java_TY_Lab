package com.mail;

import java.io.IOException;
import java.util.Properties;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/MailServlet")
public class MailServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        final String from = "virajpotdar4@gmail.com";
        final String password = "ejnd ykfv xutp nlgp";

        Properties p = new Properties();

        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(p,
            new Authenticator() {

                protected PasswordAuthentication
                getPasswordAuthentication() {

                    return new PasswordAuthentication(
                        from, password);
                }
            });

        try {

            Message mail = new MimeMessage(session);

            mail.setFrom(new InternetAddress(from));

            mail.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(to));

            mail.setSubject(subject);
            mail.setText(message);

            Transport.send(mail);

            request.setAttribute(
                "msg", "Email sent successfully!");

        } catch (MessagingException e) {

            request.setAttribute(
                "msg", "Email failed: " + e.getMessage());
        }

        request.getRequestDispatcher("mail.jsp")
               .forward(request, response);
    }
}