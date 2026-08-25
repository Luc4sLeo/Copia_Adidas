# Implementação de 3 Telas Conectadas - App Adidas

Este plano detalha a criação de três telas principais para o aplicativo Adidas: Home, Lista de Produtos e Detalhes do Produto, utilizando Java e layouts XML.

## User Review Required

> [!IMPORTANT]
> O projeto utiliza **Java** e **XML**. Vou manter esse padrão.
> Para a lista de produtos, usaremos um `RecyclerView`, que é o componente padrão do Android para listas eficientes.

## Proposed Changes

### 1. Tela Home (`MainActivity`)
Ajustar o layout atual para incluir banners de categorias.

#### [MODIFY] [activity_main.xml](file:///Users/senai/AndroidStudioProjects/Adidas/app/src/main/res/layout/activity_main.xml)
- Adicionar botões/imagens para as categorias "Calçados", "Roupas" e "Acessórios".
- Melhorar a disposição visual com `ScrollView`.

### 2. Tela de Lista de Produtos (`ProductListActivity`)
Nova tela que mostra os produtos de uma categoria.

#### [NEW] [activity_product_list.xml](file:///Users/senai/AndroidStudioProjects/Adidas/app/src/main/res/layout/activity_product_list.xml)
- Conterá um `RecyclerView` para a lista.

#### [NEW] [ProductListActivity.java](file:///Users/senai/AndroidStudioProjects/Adidas/app/src/main/java/com/example/adidas/ProductListActivity.java)
- Gerenciará a exibição dos produtos.

### 3. Tela de Detalhes (`ProductDetailActivity`)
Nova tela que mostra informações detalhadas de um item selecionado.

#### [NEW] [activity_product_detail.xml](file:///Users/senai/AndroidStudioProjects/Adidas/app/src/main/res/layout/activity_product_detail.xml)
- Exibirá imagem, nome, descrição, preço e um botão de compra.

#### [NEW] [ProductDetailActivity.java](file:///Users/senai/AndroidStudioProjects/Adidas/app/src/main/java/com/example/adidas/ProductDetailActivity.java)
- Receberá os dados do produto via `Intent` e preencherá a tela.

### 4. Configurações de Sistema
#### [MODIFY] [AndroidManifest.xml](file:///Users/senai/AndroidStudioProjects/Adidas/app/src/main/AndroidManifest.xml)
- Registrar as novas atividades.

## Verification Plan

### Manual Verification
1. Abrir o app e verificar se a Home aparece corretamente.
2. Clicar em uma categoria e ver se abre a Lista de Produtos.
3. Clicar em um produto da lista e ver se abre a tela de Detalhes.
4. Testar o botão "Voltar" em todas as telas.
