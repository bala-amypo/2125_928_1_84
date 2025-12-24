import java.time.LocalDate;

if (entry.getServiceDate().isAfter(LocalDate.now())) {
    throw new IllegalArgumentException("future");
}
