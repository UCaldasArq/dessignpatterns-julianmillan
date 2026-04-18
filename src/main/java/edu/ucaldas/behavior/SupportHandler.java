package edu.ucaldas.behavior;

// TODO: Implementa el patrón Chain of Responsibility.
// Crea tres manejadores concretos:
// 1. BasicSupportHandler → maneja solicitudes "básicas"
// 2. SupervisorHandler → maneja solicitudes "intermedias"
// 3. ManagerHandler → maneja solicitudes "avanzadas"
// Si no puede manejar, debe pasar al siguiente en la cadena.



public class SupportHandler {
    public static Handler createChain() {
        Handler basic = new BasicSupportHandler();
        Handler supervisor = new SupervisorHandler();
        Handler manager = new ManagerHandler();

        basic.setNext(supervisor);
        supervisor.setNext(manager);

        return basic;
    }

    static class BasicSupportHandler extends Handler {
        @Override
        public String handleRequest(String request) {
            if ("básica".equalsIgnoreCase(request)) {
                return "Atendido por Soporte Básico";
            }
            return next != null ? next.handleRequest(request) : "No se puede atender la solicitud.";
        }
    }

    static class SupervisorHandler extends Handler {
        @Override
        public String handleRequest(String request) {
            if ("intermedia".equalsIgnoreCase(request)) {
                return "Atendido por Supervisor";
            }
            return next != null ? next.handleRequest(request) : "No se puede atender la solicitud.";
        }
    }

    static class ManagerHandler extends Handler {
        @Override
        public String handleRequest(String request) {
            if ("avanzada".equalsIgnoreCase(request)) {
                return "Atendido por Gerente";
            }
            return next != null ? next.handleRequest(request) : "No se puede atender la solicitud.";
        }
    }
}
