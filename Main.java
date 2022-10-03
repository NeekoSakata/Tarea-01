import java.util.Date;
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

class DetalleOrden{
    public DetalleOrden(int a, float b, String c, String d, float e){
        cantidad = a;
        Ar = new Articulo(b, c, d, e);
    }
    public float calcPrecio(){
        return Ar.getPrecio() * cantidad;
    }
    public float calcPrecioSinIVA(){
        return Ar.getPrecio() - ((Ar.getPrecio() * 19) / 100);
    }
    public float calcIVA(){
        return (Ar.getPrecio() * 19) / 100;
    }
    public float calcPeso(){
        return Ar.getPeso() * cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }
    private int cantidad;
    private Articulo Ar;
}

class OrdenCompra {
    public OrdenCompra(Date a, String b, int f, float g, String c, String d, float e) {
        fecha = a;
        estado = b;
        detalleOrden = new DetalleOrden(f, g, c, d, e);
    }

    public float calcPrecio() {
        return detalleOrden.calcPrecio();
    }
    public float calcPrecioSinIVA() {
        return detalleOrden.calcPrecioSinIVA();
    }
    public float calcIVA() {
        return detalleOrden.calcIVA();
    }
    public float calcPeso() {
        return detalleOrden.calcPeso();
    }

    public Date getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    private Date fecha;
    private String estado;
    private DetalleOrden detalleOrden;
}

abstract class Pago {
    private float monto;
    private Date fecha;

    public Pago(float m, Date f) {
        monto = m;
        fecha = f;
    }

    public float getMonto() {
        return monto;
    }

    public Date getFecha() {
        return fecha;
    }
}

/*
class Efectivo extends Pago{
    private OrdenCompra costo;             //Decidi usar una instanciaa de OrdenCompra para poder sacar el coste en cuestiony restarle a monto para obtener el vuelto.(falta funcion OrdenCompra)
    public Efectivo(OrdenCompra co){
        costo=co;
    }
    public float calcDevolucion(float monto, OrdenCompra costo ){
        return super.monto - OrdenCompra.calcPrecio();

    }
}
*/
class Transferencia extends Pago {
    private String banco;
    private String numCuenta;

    public Transferencia(float m, Date f, String b, String c) {
        super(m, f);
        banco = b;
        numCuenta = c;
    }

    public String getBanco() {
        return banco;
    }

    public String getNumCuenta() {
        return numCuenta;
    }
}

class Tarjeta extends Pago {
    private String tipo;
    private String numTransaccion;

    public Tarjeta(float m, Date f, String t, String nt) {
        super(m, f);
        tipo = t;
        numTransaccion = nt;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNumTransaccion() {
        return numTransaccion;
    }
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