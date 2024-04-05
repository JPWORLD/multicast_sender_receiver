

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastSender {
    public static void main(String[] args) {
        try {
            // Create a multicast socket
            DatagramSocket socket = new DatagramSocket();

            // Define the multicast group address
            InetAddress group = InetAddress.getByName("239.0.0.1");

            // Message to be sent
            String message = "414E43003100FD0203110100000000020469506164DBC541302A000000000000000000000000000010D7276B01000000A80050C234F71C01070000";
            byte[] data = message.getBytes();

            while (true) {
                // Create a packet for the message and set the destination multicast group
                DatagramPacket packet = new DatagramPacket(data, data.length, group, 4446);

                // Send the packet
                socket.send(packet);

                // Wait for 1 second before sending the next message
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
