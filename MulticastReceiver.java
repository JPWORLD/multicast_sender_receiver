

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver {
    public static void main(String[] args) {
        try {
            // Create a multicast socket bound to the specific port
            MulticastSocket socket = new MulticastSocket(4446);

            // Define the multicast group address
            InetAddress group = InetAddress.getByName("239.0.0.1");

            // Join the multicast group
            socket.joinGroup(group);

            // Continuously receive and process messages
            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // Receive the packet
                socket.receive(packet);

                // Convert the packet data to a string and print it
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

