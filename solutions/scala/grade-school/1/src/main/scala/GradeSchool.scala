import scala.collection.immutable.TreeMap

class School {
  type DB = Map[Int, Seq[String]]

  // Estado interno (mutável), mas guardando uma estrutura imutável.
  // Começa vazio como os testes esperam.
  private var state: DB = Map.empty

  // Exposição do "db" atual (os testes fazem school.db should be (Map()) etc.)
  def db: DB = state

  // Adiciona aluno ao final da Seq para preservar a ordem de inserção
  // (o teste "James, Blair, Paul" espera exatamente nessa ordem).
  //
  // Retorna Boolean pra "indicar incorreto" quando tentar duplicar.
  // Os testes mostrados não checam o retorno, então não atrapalha.
  def add(name: String, g: Int): Boolean = {
    val alreadyExists = state.values.exists(_.contains(name))
    if (alreadyExists) false
    else {
      val current = state.getOrElse(g, Seq.empty)
      state = state.updated(g, current :+ name)
      true
    }
  }

  // Retorna a lista como foi inserida; se não existir, Seq()
  def grade(g: Int): Seq[String] =
    state.getOrElse(g, Seq.empty)

  // Retorna a escola ordenada:
  // - chaves (grades) em ordem crescente
  // - nomes em cada grade em ordem alfabética
  //
  // TreeMap garante que keys.toList venha (3,4,6) como no teste.
  def sorted: DB = {
    val normalized = state.toSeq.map { case (g, names) =>
      (g, names.sorted)
    }
    TreeMap.from(normalized)
  }
}