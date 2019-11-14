package ru.tyurintrade;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class Keystore {
	
	public static SSLSocketFactory init () throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, UnrecoverableKeyException, KeyManagementException {
	// load up the key store
			final String STORETYPE = "JKS";
			final String KEYSTORE = "D:/keystore.jks";
			final String STOREPASSWORD = "1";
			final String KEYPASSWORD = "1";

			KeyStore ks = KeyStore.getInstance( STORETYPE );
			File kf = new File( KEYSTORE );
			ks.load( new FileInputStream( kf ), STOREPASSWORD.toCharArray() );

			KeyManagerFactory kmf = KeyManagerFactory.getInstance( "SunX509" );
			kmf.init( ks, KEYPASSWORD.toCharArray() );
			TrustManagerFactory tmf = TrustManagerFactory.getInstance( "SunX509" );
			tmf.init( ks );
			
			SSLContext sslContext = SSLContext.getInstance( "TLS" );
			sslContext.init( null, tmf.getTrustManagers(), null );
			// sslContext.init( null, null, null ); // will use java's default key and trust store which is sufficient unless you deal with self-signed certificates

			return sslContext.getSocketFactory();// (SSLSocketFactory) SSLSocketFactory.getDefault();
	}
}
