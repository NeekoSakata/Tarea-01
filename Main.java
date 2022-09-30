class Direccion{
    public Direccion(String a){
        direccion = a;
    }
    public String getDireccion(){
        return direccion;
    }
    private String direccion;
}

class Cliente{
    public Cliente(String a, String b){
        nombre = a;
        rut = b;
    }
    public String getNombre(){
        return nombre;
    }
    public String getRut(){
        return rut;
    }
    private String nombre;
    private String rut;
}
class Articulo{
    public Articulo(float a, String b, String c, float d){
        peso = a;
        nombre = b;
        descripcion = c;
        precio = d;
    }

    public float getPeso(){
        return peso;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public float getPrecio(){
        return precio;
    }

    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;
}


public class Main {
    public static void main(String[] args) {
        Direccion a = new Direccion("Av Parques de Carriel");
        System.out.println(a.getDireccion());
        Cliente yo = new Cliente("Nicolas Torres", "21.084.461-9");
        System.out.println(yo.getNombre() + "\n" + yo.getRut());
        Articulo b = new Articulo(0.65f, "Botella de agua", "Tiene agua", 9.99f);
        System.out.println(b.getPeso() + "\n" + b.getNombre() + "\n" + b.getDescripcion() + "\n" + b.getPrecio());
    }
}