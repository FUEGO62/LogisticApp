import org.Cryptography.CaesarCipher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaesarCipherTest {

    @Test
    public void testEncryptReturnsEncryptedString() {
        String encryptedCode = CaesarCipher.encrypt("CODEDAMN",3);
        assertEquals(encryptedCode, "FRGHGDPQ");
    }
}
