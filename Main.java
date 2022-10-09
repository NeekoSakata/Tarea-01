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
    private OrdenCompra costo;

    public Pago(float m, Date f, OrdenCompra c) {       //cambio 1
        monto = m;
        fecha = f;
        costo = c;
    }

    public float getMonto() {
        return monto;
    }

    public Date getFecha() {
        return fecha;
    }
    public float getCosto(){
        return costo.calcPrecio();
    }
}

class Efectivo extends Pago{
    public Efectivo(float m, Date f, OrdenCompra c){
        super(m,f,c);
    }
    public float calcDevolucion(){
        return getMonto() - getCosto();
        //Nota: Si el costo es mayor al monto queda en negativo, dejamos esto así para representar que el comprador queda debiendo dinero
    }
}

class Transferencia extends Pago {
    private String banco;
    private String numCuenta;

    public Transferencia(float m, Date f, String b, String nc, OrdenCompra c) {
        super(m, f, c);
        banco = b;
        numCuenta = nc;
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

    public Tarjeta(float m, Date f, String t, String nt, OrdenCompra c) {
        super(m, f, c);
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
class DocTributario{
    private String numero;
    private String rut;
    private Date fecha;
    public DocTributario(String n, String r, Date f){
        numero = n;
        rut = r;
        fecha = f;
    }
    public String getNumero(){
        return numero;
    }
    public String getRut(){
        return rut;
    }
    public Date getFecha(){
        return fecha;
    }
}
class Boleta extends DocTributario{
    public Boleta(String n, String r, Date f){
        super(n,r,f);
    }
}
class Factura extends DocTributario{
    public Factura(String n, String r, Date f){
        super(n,r,f);

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
        Date d = new Date(122,5,5);
        System.out.println(d);
        OrdenCompra c = new OrdenCompra(d,"Completado",54,55,"Papa","Es un papa",9500); // Date as, String b, int f, float g, String c, String d, float e
        Efectivo p1 = new Efectivo(10000,d,c);
        System.out.println(p1.calcDevolucion());

    }
}
