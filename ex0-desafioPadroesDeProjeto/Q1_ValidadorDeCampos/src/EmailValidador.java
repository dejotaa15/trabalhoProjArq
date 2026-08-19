public class EmailValidador implements ValidadorInterface{
    @Override
    public boolean valida(String valor){
        if(valor==null){
            return false;
        }
        int posA = valor.indexOf('@');
                int posPt = valor.indexOf('.');
                if (posA <= 0 || posPt <= 0) return false;
                return true;

    }
}