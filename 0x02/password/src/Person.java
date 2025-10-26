public class Person {

    public boolean checkUser(String username) {
        // Deve ter no mínimo 8 caracteres
        if (username.length() < 8) return false;

        // Não deve conter caracteres especiais (apenas letras e números)
        return username.matches("^[a-zA-Z0-9]+$");
    }

    public boolean checkPassword(String password) {
        // Deve ter no mínimo 8 caracteres
        if (password.length() < 8) return false;

        // Deve conter pelo menos uma letra maiúscula
        if (!password.matches(".*[A-Z].*")) return false;

        // Deve conter pelo menos um número
        if (!password.matches(".*\\d.*")) return false;

        // Deve conter pelo menos um caractere especial
        if (!password.matches(".*[^a-zA-Z0-9].*")) return false;

        return true;
    }
}

