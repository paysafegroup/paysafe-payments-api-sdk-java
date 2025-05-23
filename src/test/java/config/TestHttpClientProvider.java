// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package config;

import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;

public class TestHttpClientProvider {

  // create sslContext that can accept WireMock's self-signed certificate
  public static SSLContext createTestSslContext() throws NoSuchAlgorithmException, KeyManagementException {

    SSLContext context = SSLContext.getInstance("TLS");
    context.init(null,
        new TrustManager[]
            {
                new X509ExtendedTrustManager() {
                  public X509Certificate[] getAcceptedIssuers() {
                    return null;
                  }

                  public void checkClientTrusted(
                      final X509Certificate[] a_certificates,
                      final String a_auth_type) {
                  }

                  public void checkServerTrusted(
                      final X509Certificate[] a_certificates,
                      final String a_auth_type) {
                  }

                  public void checkClientTrusted(
                      final X509Certificate[] a_certificates,
                      final String a_auth_type,
                      final Socket a_socket) {
                  }

                  public void checkServerTrusted(
                      final X509Certificate[] a_certificates,
                      final String a_auth_type,
                      final Socket a_socket) {
                  }

                  public void checkClientTrusted(
                      final X509Certificate[] a_certificates,
                      final String a_auth_type,
                      final SSLEngine a_engine) {
                  }

                  public void checkServerTrusted(
                      final X509Certificate[] a_certificates,
                      final String a_auth_type,
                      final SSLEngine a_engine) {
                  }
                }
            },
        null);

    return context;
  }

}
