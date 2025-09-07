interface Vehiculo {
    void acelerar();
}

interface ConMotor extends Vehiculo {
    void usarMotor();
}

interface Pedaleable extends Vehiculo {
    void pedalear();
}

class Coche implements ConMotor {
    @Override
    public void acelerar() {
        usarMotor();
    }

    @Override
    public void usarMotor() {
        System.out.println("El coche acelera usando el motor.");
    }
}

class Bicicleta implements Pedaleable {
    @Override
    public void acelerar() {
        pedalear();
    }

    @Override
    public void pedalear() {
        System.out.println("La bicicleta acelera pedaleando.");
    }
}

