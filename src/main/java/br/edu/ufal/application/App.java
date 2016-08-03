package br.edu.ufal.application;

import br.edu.ufal.controller.Controller;
import br.edu.ufal.view.Capture;
import br.edu.ufal.view.Screen;

public class App {

	public static void main(String[] args){

		boolean loopGeneral = true;
		boolean loop;


		while(loopGeneral){

			loop = true;
			Screen.menuDisplayLogin();//MENU INICIAL
			switch (Capture.getOptionInt()){
			//OPCOES INICIAIS

			case 1://LOGIN
				
				int idUser = Controller.authenticationLogin();
				if(idUser != -1){
					//USER AUTORIZADO

					while(loop){
						//LOOP DE NAVEGACAO

						Screen.displayInitialMenu();
						//MENU INICIAL

						switch(Capture.getOptionInt()){
						//NAVEGACAO	


						case 1://PERFIL
							Controller.printProfile(idUser);

							Screen.profileOption();

							switch(Capture.getOptionInt()){ //OPCOES EDITAR/VOLTAR

							case 1://EDITAR PERFIL

								Screen.profileEditionOption();

								switch(Capture.getOptionInt()){ //O QUE SE DESEJA EDITAR

								case 1: //NOME
									Controller.Edition(idUser, "name");
									break;
								
								case 2: //SOBRENOME
									Controller.Edition(idUser, "lastName");
									break;
								case 3: //SEXO
									Controller.Edition(idUser, "sex");
									break;
								case 4: //DT NASC
									Controller.Edition(idUser, "dateBirth");
									break;
								case 5: //CONTATO
									Controller.Edition(idUser, "contact");
									break;
								case 6: //STATUS
									Controller.Edition(idUser, "status");
									break;
								case 7: //INFORMACOES PROFISSIONAIS
									Controller.EditionInformationProfessional(idUser);
									break;
								case 8: //INFORMACOES EDUCACIONAIS
									Controller.EditionInformationEducational(idUser);
									break;
								default: // VOLTAR
									//QUALQUER OPCAO FORA DO INTERVALO VOLTA
								}

								break;
							default: //VOLTAR
								//VOLTA COM QUALQUER VALOR DIFERENTE DO 1

							}
//
//							break;
//						case 2: //AMIGOS
//
//							out.menuAmigos();
//
//							switch(in.obterOpcao()){
//							case 1: //SOLICITACOES DE AMIZADE
//								control.gerUsers.listaSolicitacoesAmizade(codUserAtual);
//
//								out.menuResponderSolicitacao();
//
//								switch(in.obterOpcao()){
//
//								case 1: //ACEITAR CONVITE
//
//									control.gerUsers.aceitarConviteAmizade(codUserAtual);
//
//									break;
//								case 2: //REJEITAR CONVITE
//
//									control.gerUsers.rejeitarConviteAmizade(codUserAtual);
//
//									break;
//								default:	
//									//VOLTAR
//								}
//
//								break;
//							case 2: //BUSCAR AMIGOS
//								control.gerUsers.listaUsuarioCadastrados(codUserAtual);
//
//								out.menuAdcAmigo();
//
//
//
//								switch(in.obterOpcao()){
//								case 1: //ENVIAR SOLICITACAO
//
//									control.gerUsers.ennviarSolicitacao(codUserAtual);
//
//									break;
//								default:
//									//VOLTAR
//								}
//
//								break;
//							case 3: //LISTAR AMIGOS
//
//								control.gerUsers.listarAmigos(codUserAtual);
//
//								break;
//							default:		
//								//VOLTAR
//							}
//
//
//							break;
//						case 3: //COMUNIDADES
//
//
//
//
//
//							break;
//						case 4: //CHAT(private)
//
//							out.menuMsgs();
//							
//							switch(in.obterOpcao()){
//							case 1: //ENVIAR MENSAGEM
//								boolean bool = true;
//								while(bool){
//									
//									control.gerUsers.listarAmigos(codUserAtual);
//									
//									if(control.gerUsers.enviarMsg(codUserAtual)  != -1){
//										out.outraMsg();
//										
//										if(in.obterOpcao() != 1){
//											bool = false;
//										}
//									} else {
//										bool = false;
//									}
//								}
								
//								break;
//							case 2://CAIXA DE MENSAGENS
//								
//								boolean temMsg = control.gerUsers.exibirCaixaEntrada(codUserAtual);
//								
//								
//								if(temMsg){
//									out.menuCxEntrada(); 
//								
//									switch(in.obterOpcao()){
//									case 1: //SELECIONAR CONVERSA
//											
//										control.gerUsers.exibirConversa(codUserAtual);
//										
//										break;
//									default:
//										
//										//VOLTAR
//								
//									} 
//								} else {
//									out.CaixaDeMsgsVazia();
//								}
//								
//								break;
//							case 3://LIMPAR HISTORICO
//								
//								control.gerUsers.limparHistorico(codUserAtual);
//								
//								break;
//							default:
//								//VOLTAR
//							}
//							
//							break;
//						case 5: //BUSCAR USUARIO
//
//							
//
//							break;
//
//						case 6: //CONFIGURACOES
//
//							out.menuConfig();
//							switch(in.obterOpcao()){
//							case 1://ALTERAR SENHA
//
//								//control.gerUsers.alterarSenha(codUserAtual);
//							
//								break;		
//							case 2:
//								//ALTERAR EMAIL
//								
//								//control.gerUsers.alterarEmail(codUserAtual);
//								
//								break;
//							case 3:
//								//EXCLUIR CONTA
//								
//								//control.gerUsers.exluirConta(codUserAtual);
//
//								break;
//							default:
//								//VOLTAR
//							}
						case 7: //LOGOUT
							loop = false;

							break;
						case 8: //ENCERRA APLICATIVO
							loop = false;
							loopGeneral = false;
							Screen.appFinalised();
							break;
					
						} //END SWITCH NAVEGACAO
					} //END LOOP NAVEGACAO
				} else { //END IF AUTORIZACAO USER
//					//ACESSO NEGADO
				}
				break;

			case 2://CADASTRO
				boolean bool = true;
				while(bool){
					if(Controller.addUser() == -1){
						
						Screen.displayMenuTryAgain();
						
						if(Capture.getOptionInt() != 1){
							bool = false;
						}
					}else {
						bool = false;
					}
				}
				
				break;

			case 3: //ENCERRAR APLICACAO
				loopGeneral = false;
				//FIM DA APLICACAO
		
			} //END SWITCH OPCOES INICIAIS
		} //END LOOP GERAL
	} //END METODO MAIN
} //END CLASS MAIN