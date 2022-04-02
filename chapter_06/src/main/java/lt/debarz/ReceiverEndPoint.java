package lt.debarz;
/**
 * Adapter interface for pushing information out to a UI port.
 */
public interface ReceiverEndPoint {
    void onTwoot(Twoot twoot);
}
