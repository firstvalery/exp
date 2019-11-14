package ru.tyurintrade;


import java.io.IOException;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.concurrent.CountDownLatch;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.websocket.Session;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import com.google.gson.Gson;

import ru.tyurintrade.json.JsonGlass;

public class MyClientEndpoint extends WebSocketClient {

	private static CountDownLatch latch;
 
    static Session sessionOnOpen = null;

	public MyClientEndpoint(URI serverUri) {
		super(serverUri);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onOpen( ServerHandshake handshakedata ) {
		//session.getBasicRemote().sendText("{\"op\": \"subscribe\", \"args\": [\"orderBookL2_25:XBTUSD\"]}");
		
		System.out.println( "Connected" );

	}

	@Override
	public void onMessage( String message ) {
		/*JsonGlass jg = new Gson().fromJson(message, JsonGlass.class);
		if(jg.getData()==null & jg.getKeys()==null) {
			System.out.println( message );
		} else if (jg.getKeys()!=null) {
			System.out.println( "received partial: "+ message);
		}else if (jg.getData()!=null) {
			System.out.println( "received new data: " + message);
		}	*/
		System.out.println(message);
	}

	@Override
	public void onClose( int code, String reason, boolean remote ) {
		System.out.println( "Disconnected" );
		System.exit(0);
	}

	@Override
	public void onError( Exception ex ) {
		ex.printStackTrace();
	}
 

 
    public static void main(String[] args) {
        latch = new CountDownLatch(1);
 
        
        try {
        	MyClientEndpoint client = new MyClientEndpoint(new URI("wss://www.bitmex.com/realtime"));
        	
        	SSLSocketFactory factory = Keystore.init();
        	

        	
        	Socket sock = new Socket();
        	sock.connect(new InetSocketAddress("www.bitmex.com" /*www.bitmex.com/realtime*/, 443), 0);
        	SSLSocket sslSock = (SSLSocket) factory.createSocket(sock, "www.bitmex.com" /*"www.bitmex.com/realtime"*/, 443, true);
        	sslSock.startHandshake();
        	client.setSocket(sslSock);

        	client.connectBlocking();
        	
        	client.send( "{\"op\": \"subscribe\", \"args\": [\"orderBookL2_25:XBTUSD\"]}" );
        	

        	
            latch.await();
		} catch (URISyntaxException | InterruptedException | UnrecoverableKeyException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException
				| CertificateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}