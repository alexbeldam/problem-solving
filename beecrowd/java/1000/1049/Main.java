class Animal {
    public static Animal valueOf(String filo, String classe, String alimentacao) {
        return filo.equals("vertebrado") ? Vertebrado.valueOf(classe, alimentacao) : Invertebrado.valueOf(classe, alimentacao);
    }

    private final String tipo;

    protected Animal(String tipo) {
        this.tipo = tipo;
    }

    public final String getTipo() {
        return tipo;
    }
}

class Vertebrado extends Animal {
    public static Vertebrado valueOf(String classe, String alimentacao) {
        return classe.equals("ave") ? Ave.valueOf(alimentacao) : Mamifero.valueOf(alimentacao);
    }

    protected Vertebrado(String tipo) {
        super(tipo);
    }
}

class Invertebrado extends Animal {
    public static Invertebrado valueOf(String classe, String alimentacao) {
        return classe.equals("inseto") ? Inseto.valueOf(alimentacao) : Anelideo.valueOf(alimentacao);
    }

    protected Invertebrado(String tipo) {
        super(tipo);
    }
}

class Ave extends Vertebrado {
    public static Ave valueOf(String alimentacao) {
        return new Ave(alimentacao.equals("carnivoro") ? "aguia" : "pomba");
    }

    private Ave(String tipo) {
        super(tipo);
    }
}

class Mamifero extends Vertebrado {
    public static Mamifero valueOf(String alimentacao) {
        return new Mamifero(alimentacao.equals("onivoro") ? "homem" : "vaca");
    }

    private Mamifero(String tipo) {
        super(tipo);
    }
}

class Inseto extends Invertebrado {
    public static Inseto valueOf(String alimentacao) {
        return new Inseto(alimentacao.equals("hematofago") ? "pulga" : "lagarta");
    }

    private Inseto(String tipo) {
        super(tipo);
    }
}

class Anelideo extends Invertebrado {
    public static Anelideo valueOf(String alimentacao) {
        return new Anelideo(alimentacao.equals("hematofago") ? "sanguessuga" : "minhoca");
    }

    private Anelideo(String tipo) {
        super(tipo);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filo = scanner.next();
        String classe = scanner.next();
        String alimentacao = scanner.next();

        Animal animal = Animal.valueOf(filo, classe, alimentacao);

        System.out.println(animal.getTipo());

        scanner.close();
    }
}