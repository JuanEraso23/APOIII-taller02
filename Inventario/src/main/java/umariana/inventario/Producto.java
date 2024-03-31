package umariana.inventario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Juan Eraso
 */
public class Producto {
    
    //Atributos
    private int id_Producto;
    private String nombre;
    private int precio;
    private int cantidad;
    
    private ArrayList<Producto> misProductos;
    private Scanner lector;


    //Constructores
    public Producto() {
        misProductos = new ArrayList<>();
        lector = new Scanner(System.in);
    }

    public Producto(int id_Producto, String nombre, int precio, int cantidad) {
        this.id_Producto = id_Producto;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    //Getters & Setters
    public int getId_Producto() {
        return id_Producto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCantidad (int cantidad) {
        this.cantidad = cantidad;
    }
    
    //Métodos
    public void mostrarMenu() {
        boolean activo = true;

        do {
            System.out.println("========= INVENTARIO ===========");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Mostrar Inventario (En Forma Ascendente)");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Salir");
            System.out.println("------------------------------------------------");

            int opcion = lector.nextInt();
            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                    
                case 2:
                    mostrarInventario();
                    break;
                    
                case 3:
                    mostrarInventarioAscendente();
                    break;
                    
                case 4:
                    eliminarProducto();
                    break;
                    
                case 5:
                    activo = false;
                    System.out.println("Hasta pronto...");
                    break;
                    
                default:
                    System.out.println("Opción no válida, inténtelo nuevamente");
            }
        } while (activo);
    }

    public void agregarProducto() {
        System.out.println("------------------------------------------------");
        System.out.println("========= Agregar Producto ===========");
        System.out.println("Ingrese la información del nuevo producto");
                    
        System.out.println("Id: ");
        id_Producto = lector.nextInt();
        
        lector.nextLine();
        System.out.println("Nombre: ");
        nombre = lector.nextLine();
        
        System.out.println("Precio: ");
        precio=lector.nextInt();
        
        System.out.println("Cantidad: ");
        cantidad = lector.nextInt();
        
        Producto nuevoProducto = new Producto(id_Producto, nombre, precio, cantidad);
        misProductos.add(nuevoProducto);
        System.out.println("Producto agregada exitosamente");
    }
    
    public void mostrarInventario() {
        System.out.println("========= Mostrar Inventario ===========");
        
        for(Producto p: misProductos) {
            System.out.println("Id: "+p.getId_Producto());
            System.out.println("Nombre: "+p.getNombre());
            System.out.println("Precio: "+p.getPrecio());
            System.out.println("Cantidad: "+p.getCantidad());        
            System.out.println("------------------------------------------------");
            System.out.println("");
        }
    }
    
    public void mostrarInventarioAscendente() {
        System.out.println("========= Mostrar Inventario (Forma Ascendente) ===========");
        
        /**
        * Orden de burbuja para reorganizar las tareas
        * Según su prioridad
        * (Mayor a Menor)
        */
        int n=misProductos.size();
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) {
                if(misProductos.get(j).getCantidad() > misProductos.get(j+1).getCantidad()) {
                    //Reorganizar las tareas en orden descendente
                    Producto temp=misProductos.get(j);
                    misProductos.set(j, misProductos.get(j+1));
                    misProductos.set(j+1, temp);
                }
            }
        }
        
        for(Producto p: misProductos) {
            System.out.println("Id: "+p.getId_Producto());
            System.out.println("Nombre: "+p.getNombre());
            System.out.println("Precio: "+p.getPrecio());
            System.out.println("Cantidad: "+p.getCantidad());        
            System.out.println("------------------------------------------------");
            System.out.println("");
        }
    }

    public void eliminarProducto() {
    System.out.println("========= Eliminar Producto ===========");
    System.out.println("Digite el ID del Producto a eliminar");

    int id = lector.nextInt();
    Iterator<Producto> it=misProductos.iterator();
        while (it.hasNext()) {
            Producto p=it.next();
            if (p.getId_Producto()==id) {
                it.remove();
                System.out.println("Producto con Id " +id+ " eliminado");
                //Salir del método después de eliminar el producto
                return; 
            }
        }
        System.out.println("Producto con Id " +id+ " no encontrado");
    }
}
