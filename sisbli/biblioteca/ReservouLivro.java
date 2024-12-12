package biblioteca;

public interface ReservouLivro {
    public void adicionar(LivroReservado livroReservado);
    public void remover(LivroReservado livroReservado);
    public void notificar(Reserva reserva);
}
