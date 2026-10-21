
package br.edu.ifms.portalrobotica.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.UUID;

import javax.naming.NamingException;
import javax.servlet.http.Part;

public class SupabaseStorage {

	private static final String PASTA_ESTUDANTES = "estudantes";
	private static final String SUPABASE_URL = "https://kbvkfvndninjqokcpzln.supabase.co";
	private static final String BUCKET = "portal-robotica";

	private final HttpClient client = HttpClient.newHttpClient();

	private String obterChave() throws IOException {
		String chave = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imtidmtmdm5kbmluanFva2NwemxuIiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTc5MDQ1MTA0MCwiZXhwIjoyMTA2MDI3MDQwfQ.VachPCRq09OwE5vtLvhlbFAMacZvr7nTfZVjR9Eek-c";

		if (chave == null || chave.isBlank()) {
			throw new IOException("A variável de ambiente SUPABASE_SERVICE_ROLE_KEY " + "não está configurada.");
		}

		return chave.trim();
	}

	public String salvarImagem(Part parte) throws IOException, NamingException, InterruptedException {

		if (parte == null || parte.getSize() == 0) {
			return null;
		}

		String nomeEnviado = parte.getSubmittedFileName();

		if (nomeEnviado == null || nomeEnviado.isBlank()) {
			throw new IOException("Nenhum arquivo de imagem foi informado.");
		}

		String nomeOriginal = Paths.get(nomeEnviado).getFileName().toString();

		int ponto = nomeOriginal.lastIndexOf(".");
		String extensao = ponto >= 0 ? nomeOriginal.substring(ponto).toLowerCase() : "";

		if (!extensao.equals(".jpg") && !extensao.equals(".jpeg") && !extensao.equals(".png")
				&& !extensao.equals(".webp")) {
			throw new IOException("Formato de imagem não permitido.");
		}

		String contentType = parte.getContentType();

		if (contentType == null || (!contentType.equalsIgnoreCase("image/jpeg")
				&& !contentType.equalsIgnoreCase("image/png") && !contentType.equalsIgnoreCase("image/webp"))) {
			throw new IOException("Tipo de imagem não permitido.");
		}

		String nomeArquivo = PASTA_ESTUDANTES + "/" + UUID.randomUUID() + extensao;

		byte[] arquivo;

		try (InputStream input = parte.getInputStream()) {
			arquivo = input.readAllBytes();
		}

		String chave = obterChave();

		String url = SUPABASE_URL + "/storage/v1/object/" + BUCKET + "/" + nomeArquivo;

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Authorization", "Bearer " + chave)
				.header("apikey", chave).header("Content-Type", contentType).header("x-upsert", "false")
				.POST(HttpRequest.BodyPublishers.ofByteArray(arquivo)).build();

		HttpResponse<String> response = client.send(request,
				HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

		if (response.statusCode() < 200 || response.statusCode() >= 300) {
			throw new IOException(
					"Erro ao enviar imagem para o Supabase. HTTP " + response.statusCode() + ": " + response.body());
		}

		return nomeArquivo;
	}

	public void excluirImagem(String caminho) throws IOException, NamingException, InterruptedException {

		if (caminho == null || caminho.isBlank()) {
			return;
		}

		String chave = obterChave();

		String url = SUPABASE_URL + "/storage/v1/object/" + BUCKET + "/" + caminho;

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Authorization", "Bearer " + chave)
				.header("apikey", chave).DELETE().build();

		HttpResponse<String> response = client.send(request,
				HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

		if (response.statusCode() < 200 || response.statusCode() >= 300) {
			throw new IOException(
					"Erro ao excluir imagem do Supabase. HTTP " + response.statusCode() + ": " + response.body());
		}
	}
}
