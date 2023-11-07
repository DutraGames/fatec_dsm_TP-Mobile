package comportamental.Dependencia;

public class Compra {
    
    Cupom cupom;
    
    public Compra(Cupom cupom) {
        this.cupom = cupom;
    }

    public void finalizar() {
        System.out.println("Compra finalizada com sucesso! \n Com o cupom: " + cupom.codigo);
    }
}
