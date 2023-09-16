package ufrn.br.taskflow.core.config;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

public class NomeDaTabelaExtractor {
    public static String obterNomeDaTabela(Class<?> entidadeClasse) {
        if (entidadeClasse.isAnnotationPresent(Entity.class)) {
            Entity entityAnnotation = entidadeClasse.getAnnotation(Entity.class);
            if (entityAnnotation != null) {
                Table tableAnnotation = entidadeClasse.getAnnotation(Table.class);
                if (tableAnnotation != null) {
                    return tableAnnotation.name();
                }
            }
        }
        // Retornar o nome padrão da tabela (derivado do nome da classe) se não for especificado.
        return entidadeClasse.getSimpleName();
    }
}
