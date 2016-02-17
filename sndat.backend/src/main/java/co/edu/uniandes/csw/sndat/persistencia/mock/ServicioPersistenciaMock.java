/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioPersistenciaMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.edu.uniandes.csw.sndat.persistencia.mock;


import co.edu.uniandes.csw.sndat.dto.Escenario;
import co.edu.uniandes.csw.sndat.dto.EventoSismico;
import co.edu.uniandes.csw.sndat.dto.ExperienciaVendedor;
import co.edu.uniandes.csw.sndat.dto.Mueble;
import co.edu.uniandes.csw.sndat.dto.ReporteSensor;
import co.edu.uniandes.csw.sndat.dto.RegistroVenta;
import co.edu.uniandes.csw.sndat.dto.TipoMueble;
import co.edu.uniandes.csw.sndat.dto.TipoUsuario;
import co.edu.uniandes.csw.sndat.dto.Usuario;
import co.edu.uniandes.csw.sndat.dto.Vendedor;
import co.edu.uniandes.csw.sndat.dto.ZonaGeografica;
import co.edu.uniandes.csw.sndat.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.sndat.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.sndat.logica.interfaces.IServicioPersistenciaMockRemote;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;

/**
 * Implementación de los servicios de persistencia
 */

public class ServicioPersistenciaMock implements IServicioPersistenciaMockRemote, IServicioPersistenciaMockLocal {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Lista con los vendedores del sistema
     */
    private static ArrayList<Vendedor> vendedores;

    /**
     * Lista con los muebles del sistema
     */
    private static ArrayList<Mueble> muebles;

    /**
     * Lista con los usuarios del sistema
     */
    private static ArrayList<Usuario> usuarios;

    /**
     * Lista con los registros de ventas
     */
    private static ArrayList<RegistroVenta> registrosVentas;
    
    private static ArrayList<ReporteSensor> reportes;
    
    private static ArrayList<EventoSismico> eventos;
    
    private static ArrayList<ZonaGeografica> zonas;
    
    private static ArrayList <Escenario> escenarios;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor de la clase. Inicializa los atributos.
     */
    public ServicioPersistenciaMock()
    {
        if (vendedores == null)
        {
            vendedores = new ArrayList();
            ArrayList<ExperienciaVendedor> experiencia = new ArrayList<ExperienciaVendedor>();

            experiencia.add(new ExperienciaVendedor(1L, "Banco de los Alpes", "Cajero", "Se desempeñó en diferentes áreas administrativas", 1998));
            vendedores.add(new Vendedor(1L, "Carlos Antonio", "Gomez Rodriguez", experiencia, 900000, 80000, "Técnico en auditoría y costos", "vendedor1"));

            experiencia.clear();
            experiencia.add(new ExperienciaVendedor(2L, "Marketplace de los Alpes", "Asesor de ventas", "Se desempeñó cómo consultor y asesor en área de ventas", 2006));
            vendedores.add(new Vendedor(2L, "Claudia", "Sanchez Guerrero", experiencia, 950000, 85000, "Comunicadora social", "vendedor2"));

            experiencia.clear();
            experiencia.add(new ExperienciaVendedor(3L, "Seguros de los Alpes", "Vendedor", "Se desempeñó como vendedora e impulsadora", 2010));
            vendedores.add(new Vendedor(3L, "Angela Patricia", "Montoya Zanabria", experiencia, 1200000, 135000, "Técnico en Gestión de mercadeo", "vendedor2"));

            experiencia.clear();
            experiencia.add(new ExperienciaVendedor(4L, "Autopartes de los Alpes", "Director de producción", "Se desempeñó cómo director en el área de producción", 2009));
            vendedores.add(new Vendedor(4L, "Juan Pablo", "Escobar Vélez", experiencia, 1000000, 100000, "Técnico en métodos de producción", "vendedor1"));

            muebles = new ArrayList<Mueble>();

            //Agrega los muebles del sistema
            muebles.add(new Mueble(1L, "Silla clásica", "Una confortable silla con estilo del siglo XIX.", TipoMueble.Interior, 45, "sillaClasica", 123));
            muebles.add(new Mueble(2L, "Sillón new wave", "Innovador y cómodo. No existen mejores palabras para describir este hermoso sillón.", TipoMueble.Interior, 60, "newWave", 5655));
            muebles.add(new Mueble(3L, "Silla moderna", "Lo último en la moda de interiores. Esta silla le brindará la comodidad e innovación que busca", TipoMueble.Interior, 50, "sillaModerna", 5464));
            muebles.add(new Mueble(4L, "Mesa de jardín", "Una bella mesa para comidas y reuniones al aire libre.", TipoMueble.Exterior, 100, "mesaJardin", 4568));
            muebles.add(new Mueble(5L, "Orange games", "Una hermosa silla con un toqué moderno y elegante. Excelente para su sala de estar", TipoMueble.Interior, 70, "sillaNaranja", 1345));
            muebles.add(new Mueble(6L, "Cama king", "Una hermosa cama hecha en cedro para dos personas. Sus sueños no volveran a ser iguales.", TipoMueble.Interior, 50, "bed", 63358));
            muebles.add(new Mueble(7L, "Silla Neoclásica", "Una bella silla con un estilo neoclásico", TipoMueble.Exterior, 65, "neoClasica", 678));
            muebles.add(new Mueble(8L, "Camarote junior", "Con diseño moderno. Sus hijos ahora podrán tener unos felices sueños.", TipoMueble.Interior, 85, "camarote", 56565));

            //Inicializa el arreglo que contiene los usuarios
            usuarios = new ArrayList<Usuario>();

            //Agrega usuarios al sistema
            usuarios.add(new Usuario("admin", "adminadmin", TipoUsuario.Administrador));
            usuarios.add(new Usuario("client", "clientclient", TipoUsuario.Cliente));

            registrosVentas = new ArrayList<RegistroVenta>();
            Random r = new Random();
            for (int e = 0; e < 8; e++) {
                RegistroVenta venta = new RegistroVenta();
                venta.setCantidad(e);
                venta.setProducto(muebles.get(e));
                venta.setFechaVenta(new Date(r.nextInt()));
                venta.setCiudad("Bogotá");
            }
            
            reportes = new ArrayList<ReporteSensor>();
            reportes.add(new ReporteSensor(12, 3, 1212414.4, 123123.34));
            
            eventos = new ArrayList<EventoSismico>();
            eventos.add(new EventoSismico(33.3, 66.3, 99.3));
            
            zonas = new ArrayList<ZonaGeografica>();
            
            zonas.add(new ZonaGeografica(11.547789, -72.920928, ZonaGeografica.ZONA_ATLANTICO_GUAJIRA, ZonaGeografica.ZONA_ATLANTICO));
            zonas.add(new ZonaGeografica(11.283611, -73.872483, ZonaGeografica.ZONA_ATLANTICO_MAGDALENA, ZonaGeografica.ZONA_ATLANTICO));
            zonas.add(new ZonaGeografica(9.389778, -75.788502, ZonaGeografica.ZONA_ATLANTICO_SUCRE, ZonaGeografica.ZONA_ATLANTICO));
            zonas.add(new ZonaGeografica( 8.988165, -76.278467, ZonaGeografica.ZONA_ATLANTICO_CORDOBA, ZonaGeografica.ZONA_ATLANTICO));
            zonas.add(new ZonaGeografica(8.606767, -76.899438, ZonaGeografica.ZONA_ATLANTICO_ANTIOQUIA, ZonaGeografica.ZONA_ATLANTICO));
            zonas.add(new ZonaGeografica( 5.572450, -77.502771, ZonaGeografica.ZONA_PACIFICO_CHOCO, ZonaGeografica.ZONA_PACIFICO));
            zonas.add(new ZonaGeografica(3.293384, -77.502600, ZonaGeografica.ZONA_PACIFICO_VALLE, ZonaGeografica.ZONA_PACIFICO));
            zonas.add(new ZonaGeografica(2.735288, -77.778793, ZonaGeografica.ZONA_PACIFICO_CAUCA, ZonaGeografica.ZONA_PACIFICO));
            zonas.add(new ZonaGeografica(1.795305, -78.870860, ZonaGeografica.ZONA_PACIFICO_NARIÑO, ZonaGeografica.ZONA_PACIFICO));

            escenarios = new ArrayList<Escenario>();
            escenarios.add(new Escenario(500, 1, 50, 1, zonas.get(0), Escenario.PERFIL_ALARMA));
            escenarios.add(new Escenario(400, 10, 50, 1, zonas.get(1), Escenario.PERFIL_INFORMATIVO));
            escenarios.add(new Escenario(500, 45, 40, 1, zonas.get(2), Escenario.PERFIL_ALARMA));
            escenarios.add(new Escenario(200, 66, 40, 1, zonas.get(3), Escenario.PERFIL_INFORMATIVO));
            escenarios.add(new Escenario(100, 50, 40, 1, zonas.get(4), Escenario.PERFIL_ALERTA));
            escenarios.add(new Escenario(200, 34, 30, 1, zonas.get(5), Escenario.PERFIL_ALARMA));
            escenarios.add(new Escenario(300, 34, 30, 1, zonas.get(6), Escenario.PERFIL_INFORMATIVO));
            escenarios.add(new Escenario(400, 34, 30, 1, zonas.get(7), Escenario.PERFIL_ALERTA));
            escenarios.add(new Escenario(500, 14, 30, 1, zonas.get(8), Escenario.PERFIL_ALARMA));
            escenarios.add(new Escenario(500, 23, 60, 1, zonas.get(7), Escenario.PERFIL_INFORMATIVO));
            escenarios.add(new Escenario(700, 400, 70, 1, zonas.get(6), Escenario.PERFIL_ALERTA));

        }
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    
    /**
     * Permite crear un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere crear.
     */
    @Override
    public void create(Object obj) throws OperacionInvalidaException
    {
        if (obj instanceof Vendedor)
        {
            Vendedor v = (Vendedor) obj;
            v.setIdentificacion(vendedores.size() + 1);
            vendedores.add(v);
        }
        else if (obj instanceof Mueble)
        {

            Mueble m = (Mueble) obj;
            m.setReferencia(muebles.size() + 1);
            muebles.add(m);
        } 
        else if (obj instanceof Usuario)
        {
            Usuario m = (Usuario) obj;
            for (Usuario us : usuarios)
            {
                if (us.getLogin().equals(m.getLogin()))
                {
                    throw new OperacionInvalidaException("El usuario '" + m.getLogin() + "' ya ha sido registrado en el sistema");
                }
                if (us.getDocumento() == m.getDocumento() && us.getTipoDocumento().equals(m.getTipoDocumento()))
                {
                    throw new OperacionInvalidaException("El usuario con documento '" + m.getDocumento() + "' ya ha sido registrado en el sistema");
                }
            }
            usuarios.add(m);
        } 
        else if (obj instanceof RegistroVenta)
        {
            registrosVentas.add((RegistroVenta) obj);
        }
        
        else if (obj instanceof ReporteSensor)
        {
            ReporteSensor rep = (ReporteSensor) obj;
            rep.generateId();
            reportes.add(rep);
        }
        
         else if (obj instanceof EventoSismico)
        {
            eventos.add((EventoSismico)obj);
        }
    }

    /**
     * Permite modificar un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere modificar.
     */
    @Override
    public void update(Object obj)
    {
        if (obj instanceof Vendedor)
        {
            Vendedor editar = (Vendedor) obj;
            Vendedor vendedor;
            for (int i = 0; i < vendedores.size(); i++)
            {
                vendedor = vendedores.get(i);
                if (vendedor.getIdentificacion() == editar.getIdentificacion())
                {
                    vendedores.set(i, editar);
                    break;
                }

            }

        }
        else if (obj instanceof Mueble)
        {
            Mueble editar = (Mueble) obj;
            Mueble mueble;
            for (int i = 0; i < muebles.size(); i++)
            {
                mueble = muebles.get(i);
                if (mueble.getReferencia() == editar.getReferencia())
                {
                    muebles.set(i, editar);
                    break;
                }
            }
        } 
        else if (obj instanceof Usuario)
        {

            Usuario editar = (Usuario) obj;
            Usuario usuario;
            for (int i = 0; i < usuarios.size(); i++)
            {
                usuario = usuarios.get(i);
                if (usuario.getLogin().equals(editar.getLogin()))
                {
                    usuarios.set(i, editar);
                    break;
                }
            }
        }
    }

    /**
     * Permite borrar un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere borrar.
     */
    @Override
    public void delete(Object obj) throws OperacionInvalidaException
    {
        if (obj instanceof Vendedor)
        {
            Vendedor vendedorABorrar = (Vendedor) obj;

            for (int e = 0; e < vendedores.size(); e++)
            {
                Vendedor ven = (Vendedor) vendedores.get(e);
                if (ven.getIdentificacion() == vendedorABorrar.getIdentificacion())
                {
                    vendedores.remove(e);
                    break;
                }
            }

        } 
        else if (obj instanceof Mueble)
        {
            Mueble mueble;
            Mueble eliminar = (Mueble) obj;
            for (int i = 0; i < muebles.size(); i++)
            {
                mueble = muebles.get(i);
                if (eliminar.getReferencia() == mueble.getReferencia())
                {
                    muebles.remove(i);
                    break;
                }

            }

        } 
        
        else if (obj instanceof Usuario)
        {
            Usuario usuarioABorrar = (Usuario) obj;
            for (RegistroVenta rv : registrosVentas)
            {
                if (rv.getComprador().getLogin().equals(usuarioABorrar.getLogin()))
                {
                    System.out.print("no borrado");
                    throw new OperacionInvalidaException("El usuario ha realizado comprar y por lo tanto no puede ser eliminado del sistema.");
                }
            }
            if (usuarioABorrar != null && usuarioABorrar.getLogin() != null)
            {
                for (int e = 0; e < usuarios.size(); e++)
                {
                    Usuario ven = (Usuario) usuarios.get(e);
                    if (ven.getLogin().equals(usuarioABorrar.getLogin()))
                    {
                        usuarios.remove(e);
                        System.out.print("borrado");
                        break;
                    }
                }
            }
        }
    }

    /**
     * Retorna la lista de todos los elementos de una clase dada que se encuentran en el sistema.
     * @param c Clase cuyos objetos quieren encontrarse en el sistema.
     * @return list Listado de todos los objetos de una clase dada que se encuentran en el sistema.
     */
    @Override
    public List findAll(Class c)
    {
        if (c.equals(Mueble.class))
        {
            return muebles;
        } 
        else if (c.equals(Vendedor.class))
        {
            return vendedores;
        } 
        else if (c.equals(Usuario.class))
        {
            return usuarios;
        } 
        else if (c.equals(RegistroVenta.class))
        {
            return registrosVentas;
        } 
        
        else if (c.equals(ReporteSensor.class))
        {
            return reportes;
        }
        
        else if(c.equals(EventoSismico.class))
        {
            return eventos;
        }
        else if(c.equals(ZonaGeografica.class))
        {
            return zonas;
        }
        else if(c.equals(Escenario.class))
        {
            return escenarios;
        }
        else
        {
            return null;
        }
    }

    /**
     * Retorna la instancia de una entidad dado un identificador y la clase de la entidadi.
     * @param c Clase de la instancia que se quiere buscar.
     * @param id Identificador unico del objeto.
     * @return obj Resultado de la consulta.
     */
    @Override
    public Object findById(Class c, Object id)
    {
        if (c.equals(Vendedor.class))
        {
            for (Object v : findAll(c))
            {
                Vendedor ven = (Vendedor) v;
                if (ven.getIdentificacion() == Long.parseLong(id.toString()))
                {
                    return ven;
                }
            }
        }
      
        else if (c.equals(Mueble.class))
        {
            for (Object v : findAll(c))
            {
                Mueble mue = (Mueble) v;
                if (Long.parseLong(id.toString())== mue.getReferencia())
                {
                    return mue;
                }
            }
        } 
        else if (c.equals(Usuario.class))
        {
            for (Object v : findAll(c))
            {
                Usuario mue = (Usuario) v;
                if (mue.getLogin().equals(id))
                {
                    return mue;
                }
            }
        }
        return null;
    }
}
