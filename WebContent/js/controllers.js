(function () {
    'use-strict';

    angular
        .module('tramiteApp.controllers', [])
        .controller('panelCtrl', panelCtrl)
        .controller('asideCtrl', asideCtrl)
        .controller('inicioSesionCtrl', inicioSesionCtrl)
        .controller('pendientesCtrl', pendientesCtrl)
        .controller('nuevoDocumentoCtrlPrtl', nuevoDocumentoCtrlPrtl)
        .controller('editarDocumentoCtrlPrtl', editarDocumentoCtrlPrtl)
        .controller('visualizarAdjuntoCtrlPrtl', visualizarAdjuntoCtrlPrtl)
        .controller('ingresarDecretosCtrlPrtl', ingresarDecretosCtrlPrtl)
        .controller('verEstadoCtrlPrtl', verEstadoCtrlPrtl)
        .controller('cambiarAdjuntoCtrlPrtl', cambiarAdjuntoCtrlPrtl)
        .controller('messageCtrlPrtl', messageCtrlPrtl);

    function panelCtrl ($uibModal, documentoFct, $filter, messageFct) {
        var panel = this;

        panel.tipo_busqueda = "0";
        panel.limite = 10;
		panel.pagina_actual = 1;
		panel.total_documentos = 0;

        panel.obtener_documentos = function (opcion) {
			documentoFct.getDocumentos(panel.pagina_actual, panel.limite, ($filter('date')(panel.desde, 'yyyy-MM-dd') || ""), ($filter('date')(panel.hasta, 'yyyy-MM-dd') || ""), (panel.numero_registro || ""), (panel.unidad_origen ? panel.unidad_origen.unidad_id : "0"), (panel.tipo_documento ? panel.tipo_documento.tipo_documento_id : "0"), "0", opcion, 1).then(function (response) {
                panel.documentos = response.data;
				panel.total_documentos = response.total;
			}).catch(function (reason) {
				messageFct.message('Ocurrió un problema --> '+reason);
			});
		};

        panel.obtener_unidades = function (filtro) {
            return documentoFct.getUnidades(filtro).then(function (response) {
				return response.map(function(item){
		          return item;
		        });
			}).catch(function (reason) {
				messageFct.message('Ocurrió un problema --> '+reason);
			});
        };

        panel.obtener_tipo_documento = function () {
            documentoFct.getTipoDocumento().then(function (response) {
                panel.tipos_documento = response;
            }).catch(function (reason) {
                console.log(reason);
            });
        };

        panel.hoy = function () {
            panel.desde = new Date();
            panel.hasta = new Date();

            panel.obtener_tipo_documento();
        };

        panel.abrir_calendario = function (calendario) {
            if (calendario == 'desde') {
                panel.desde_seleccionado = true;
            } else {
                panel.hasta_seleccionado = true;
            }
        };

        panel.hoy();

        panel.nuevo_documento = function () {
            var modalNuevoDocumento = $uibModal.open({
				templateUrl: 'views/partials/nuevo_documento_tpl_prtl.html',
				controller: 'nuevoDocumentoCtrlPrtl as nuevo_documento',
				size: 'md'
			});

			modalNuevoDocumento.result.then(function (response) {
				console.log(response);
			}, function () {
				console.log('Modal dismissed at: ' + new Date());
			});
        };

        panel.editar_documento = function (documento) {
            var modalEditarDocumento = $uibModal.open({
				templateUrl: 'views/partials/editar_documento_tpl_prtl.html',
				controller: 'editarDocumentoCtrlPrtl as editar_documento',
				size: 'md',
                resolve : {
                    documento : function () {
                        return documento;
                    }
                }
			});

			modalEditarDocumento.result.then(function (response) {
				console.log(response);
			}, function () {
				console.log('Modal dismissed at: ' + new Date());
			});
        };

        /*panel.visualizar_adjunto = function () {
            var modalVisualizarAdjunto = $uibModal.open({
				templateUrl: 'views/partials/visualizar_adjunto_tpl_prtl.html',
				controller: 'visualizarAdjuntoCtrlPrtl as visualizar_adjunto',
				size: 'md'
			});

			modalVisualizarAdjunto.result.then(function (response) {
				console.log(response);
			}, function () {
				console.log('Modal dismissed at: ' + new Date());
			});
        };*/

        panel.cambiar_adjunto = function (documento) {
            var modalCambiarAdjunto = $uibModal.open({
				templateUrl: 'views/partials/cambiar_adjunto_tpl_prtl.html',
				controller: 'cambiarAdjuntoCtrlPrtl as cambiar_adjunto',
				size: 'sm',
                resolve : {
                    documento : function () {
                        return documento;
                    }
                }
			});

			modalCambiarAdjunto.result.then(function (response) {
				console.log(response);
			}, function () {
				console.log('Modal dismissed at: ' + new Date());
			});
        };

        panel.ingresar_decretos = function (documento) {
            var modalIngresarDecretos = $uibModal.open({
				templateUrl: 'views/partials/ingresar_decretos_tpl_prtl.html',
				controller: 'ingresarDecretosCtrlPrtl as ingresar_decretos',
				size: 'md',
                resolve : {
                    documento : function () {
                        return documento;
                    }
                }
			});

			modalIngresarDecretos.result.then(function (response) {
				console.log(response);
			}, function () {
				console.log('Modal dismissed at: ' + new Date());
			});
        };

        panel.ver_estado = function (documento) {
            var modalVerEstado = $uibModal.open({
				templateUrl: 'views/partials/ver_estado_tpl_prtl.html',
				controller: 'verEstadoCtrlPrtl as ver_estado',
				size: 'sm',
                resolve : {
                    documento : function () {
                        return documento;
                    }
                }
			});

			modalVerEstado.result.then(function (response) {
				console.log(response);
			}, function () {
				console.log('Modal dismissed at: ' + new Date());
			});
        };
    }

    function asideCtrl ($timeout, usuarioFct, $window, $rootScope) {
        var aside = this;

        aside.clock = "Cargando fecha y hora ...";
        aside.tickInterval = 1000;

        var tick = function() {
            aside.clock = Date.now();
            $timeout(tick, aside.tickInterval);
        };

        $timeout(tick, aside.tickInterval);

        aside.inicializar = function () {
			var empleado = JSON.parse($window.sessionStorage.empleado);
			$rootScope.empleado = empleado.usuario;
		};

        aside.inicializar();

        aside.cerrar_sesion = function () {
            usuarioFct.estaAutenticado = false;

            delete $window.sessionStorage.logged_in;
            delete $window.sessionStorage.empleado;

            $rootScope.bandLogOut = true;

            $state.go("acceso.inicio_sesion");
		};
    }

    function inicioSesionCtrl ($timeout, $window, usuarioFct, $state) {
        var inicio_sesion = this;

        inicio_sesion.iniciar_sesion = function (username, password) {
			inicio_sesion.message = null;
			if (username !== undefined && password !== undefined) {
                inicio_sesion.tipo_mensaje = 'primary';
                inicio_sesion.icon = 'eye-open';
                inicio_sesion.mensaje = 'Validando datos.';
                $timeout(function(){
                    usuarioFct.iniciar_sesion(username, password).then(function (response) {
                    	if (response.data.estado == 1) {
	                    	inicio_sesion.tipo_mensaje = 'success';
	                    	inicio_sesion.icon = 'ok';
	                		inicio_sesion.mensaje = 'Datos correctos redireccionando.';

	                		$timeout(function(){
                                $window.sessionStorage.logged_in = true;

                                $state.go("app.panel");
	                        }, 1000);
	                    } else if (response.data.estado == 2) {
	                    	inicio_sesion.tipo_mensaje = 'warning';
	                    	inicio_sesion.icon = 'warning-sign';
	                		inicio_sesion.mensaje = 'Datos incorrectos.';
	                    }  else if (response.data.estado === 0) {
	                    	inicio_sesion.tipo_mensaje = 'danger';
	                    	inicio_sesion.icon = 'remove';
	                		inicio_sesion.mensaje = 'No existe usuario.';
	                    }
                    })
					.catch(function (reason) {
						inicio_sesion.tipo_mensaje = 'default';
						inicio_sesion.icon = 'fire';
	                	inicio_sesion.mensaje = reason.status+' '+reason.statusText;
					});
                }, 1000);
            }
		};
    }

    function pendientesCtrl (documentoFct, messageFct) {
        var pendientes = this;

        pendientes.limite = 10;
		pendientes.pagina_actual = 1;
		pendientes.total_documentos = 0;

        pendientes.obtener_secciones = function () {
            documentoFct.getSecciones().then(function (response) {
                pendientes.secciones = response;
                pendientes.decreto = pendientes.secciones[0];
                pendientes.obtener_documentos(pendientes.secciones[0].seccion_id);
            }).catch(function (reason) {
                console.log(reason);
            });
        };

        pendientes.obtener_documentos = function (destino) {
			documentoFct.getDocumentos(pendientes.pagina_actual, pendientes.limite, "", "", "", "", "", destino, 4, 2).then(function (response) {
                pendientes.documentos = response.data;
				pendientes.total_documentos = response.total;
			}).catch(function (reason) {
				messageFct.message('Ocurrió un problema --> '+reason);
			});
		};

        pendientes.inicializar = function () {
            pendientes.obtener_secciones();
        };
    }

    function nuevoDocumentoCtrlPrtl ($uibModalInstance, documentoFct, messageFct, $filter, Upload) {
        var nuevo_documento = this;

        nuevo_documento.fecha_documento = new Date();

        nuevo_documento.cerrar = function () {
            $uibModalInstance.dismiss();
        };

        nuevo_documento.abrir_calendario = function () {
            nuevo_documento.fecha_documento_seleccionado = true;
        };

        nuevo_documento.obtener_tipo_documento = function () {
            documentoFct.getTipoDocumento().then(function (response) {
                nuevo_documento.tipos_documento = response;
                nuevo_documento.obtener_secciones();
            }).catch(function (reason) {
                console.log(reason);
            });
        };

        nuevo_documento.obtener_secciones = function () {
            documentoFct.getSecciones().then(function (response) {
                nuevo_documento.secciones = response;
                nuevo_documento.obtener_clasificaciones();
            }).catch(function (reason) {
                console.log(reason);
            });
        };

        nuevo_documento.obtener_clasificaciones = function () {
            documentoFct.getClasificaciones().then(function (response) {
                nuevo_documento.clasificaciones = response;
                nuevo_documento.obtener_acciones();
            }).catch(function (reason) {
                console.log(reason);
            });
        };

        nuevo_documento.obtener_acciones = function () {
            documentoFct.getAcciones().then(function (response) {
                nuevo_documento.acciones = response;
            }).catch(function (reason) {
                console.log(reason);
            });
        };

        nuevo_documento.inicializar = function () {
            nuevo_documento.obtener_tipo_documento();
        };

        nuevo_documento.inicializar();

        nuevo_documento.obtener_unidades = function (filtro) {
            return documentoFct.getUnidades(filtro).then(function (response) {
				return response.map(function(item){
		          return item;
		        });
			}).catch(function (reason) {
				messageFct.message('Ocurrió un problema --> '+reason);
			});
        };

        nuevo_documento.guardar_documento = function(adjunto){
            if (adjunto) {
                nuevo_documento.cargar_adjunto(adjunto);
            }
        };

        nuevo_documento.cargar_adjunto = function (file) {
            Upload.upload({
                url : 'ServletArchivo',
                data: {file : file}
            }).then(function (resp) {
                if(resp.data.estado === 1){
                    var data = $.param({
                        asunto : nuevo_documento.asunto,
                        documento_fecha : $filter('date')(nuevo_documento.fecha_documento, 'yyyy-MM-dd'),
                        tipo_documento_id : nuevo_documento.tipo_documento.tipo_documento_id,
                        documento_numero : nuevo_documento.numero_documento || '000',
                        unidad_id_origen : nuevo_documento.unidad_origen.unidad_id,
                        seccion_id_destino : nuevo_documento.destino.seccion_id,
                        clasificacion_id : nuevo_documento.clasificacion.clasificacion_id,
                        accion : nuevo_documento.accion.accion_id,
                        observacion : nuevo_documento.observacion || null,
                        url_archivo : resp.data.adjunto,
                        opcion : 'reg'
        			});

                    documentoFct.saveDocumento(data).then(function (response) {
                        if (response.estado == 1) {
        					messageFct.message('Se creó correctamente el documento N° -> '+response.documento_id);

        					$uibModalInstance.close(true);
        				}  else {
        					messageFct.message("Ocurrió un error al intentar registrar el documento");
        				}
                    }).catch(function (reason) {
                        console.log(reason);
                    });
                } else {
                    messageFct.message('Ocurrió un error al intentar cargar el archivo');
                }
            }, function (resp) {
                console.log('Estado de error : ' + resp.status);
                nuevo_documento.progreso = undefined;
            }, function (evt) {
                var progreso_carga = parseInt(100.0 * evt.loaded / evt.total);

                nuevo_documento.progreso = 'Subiendo : ' + progreso_carga + '% ';
                nuevo_documento.valor = progreso_carga;
            });
        };
    }

    function editarDocumentoCtrlPrtl ($uibModalInstance, documento, documentoFct, messageFct, $filter) {
        var editar_documento = this;

        editar_documento.documento = documento;
        editar_documento.unidad_origen = {unidad_id: editar_documento.documento.unidad_id, unidad: editar_documento.documento.unidad};

        editar_documento.fecha_documento = new Date(editar_documento.documento.documento_fecha);

        editar_documento.cerrar = function () {
            $uibModalInstance.dismiss();
        };

        editar_documento.abrir_calendario = function () {
            editar_documento.fecha_documento_seleccionado = true;
        };

        editar_documento.obtener_tipo_documento = function () {
            documentoFct.getTipoDocumento().then(function (response) {
                editar_documento.tipos_documento = response;
                editar_documento.tipo_documento = _.find(editar_documento.tipos_documento, function (objTipoDocumento) {
    				return objTipoDocumento.tipo_documento_id == editar_documento.documento.tipo_documento_id;
    			});
                editar_documento.obtener_secciones();
            }).catch(function (reason) {
                console.log(reason);
            });
        };

        editar_documento.obtener_secciones = function () {
            documentoFct.getSecciones().then(function (response) {
                editar_documento.secciones = response;
                editar_documento.destino = _.find(editar_documento.secciones, function (objSeccion) {
    				return objSeccion.seccion_id_destino == editar_documento.documento.seccion_id_destino;
    			});
                editar_documento.obtener_clasificaciones();
            }).catch(function (reason) {
                console.log(reason);
            });
        };

        editar_documento.obtener_clasificaciones = function () {
            documentoFct.getClasificaciones().then(function (response) {
                editar_documento.clasificaciones = response;
                editar_documento.clasificacion = _.find(editar_documento.clasificaciones, function (objClasificacion) {
    				return objClasificacion.clasificacion_id == editar_documento.documento.clasificacion_id;
    			});
                editar_documento.obtener_acciones();
            }).catch(function (reason) {
                console.log(reason);
            });
        };

        editar_documento.obtener_acciones = function () {
            documentoFct.getAcciones().then(function (response) {
                editar_documento.acciones = response;
                editar_documento.accion = _.find(editar_documento.acciones, function (objAccion) {
    				return objAccion.accion_id == editar_documento.documento.accion_id;
    			});
            }).catch(function (reason) {
                console.log(reason);
            });
        };

        editar_documento.inicializar = function () {
            editar_documento.obtener_tipo_documento();
        };

        editar_documento.guardar_documento = function () {
            var data = $.param({
                asunto : editar_documento.asunto,
                documento_fecha : $filter('date')(editar_documento.fecha_documento, 'yyyy-MM-dd'),
                tipo_documento_id : editar_documento.tipo_documento.tipo_documento_id,
                documento_numero : editar_documento.numero_documento || '000',
                unidad_id_origen : editar_documento.unidad_origen.unidad_id,
                seccion_id_destino : editar_documento.destino.seccion_id,
                clasificacion_id : editar_documento.clasificacion.clasificacion_id,
                accion : editar_documento.accion.accion_id,
                observacion : editar_documento.observacion || null,
                opcion : 'edi'
            });

            documentoFct.saveDocumento(data).then(function (response) {
                if (response.estado == 1) {
                    messageFct.message('Se modificó correctamente el documento N° -> '+editar_documento.documento.documento_id);

                    $uibModalInstance.close(true);
                }  else {
                    messageFct.message("Ocurrió un error al intentar registrar el documento");
                }
            }).catch(function (reason) {
                console.log(reason);
            });
        };
    }

    function visualizarAdjuntoCtrlPrtl ($scope, $uibModalInstance) {
        var visualizar_adjunto = this;

        visualizar_adjunto.cerrar = function () {
            $uibModalInstance.dismiss();
        };
    }

    function ingresarDecretosCtrlPrtl ($uibModalInstance, documentoFct, documento, $filter, messageFct) {
        var ingresar_decretos = this;

        ingresar_decretos.documento = documento;

        ingresar_decretos.cerrar = function () {
            $uibModalInstance.dismiss();
        };

        ingresar_decretos.obtener_secciones = function () {
            documentoFct.getSecciones().then(function (response) {
                ingresar_decretos.secciones = response;
            }).catch(function (reason) {
                console.log(reason);
            });
        };

        ingresar_decretos.obtener_disposiciones = function () {
            documentoFct.getDisposiciones().then(function (response) {
                ingresar_decretos.disposiciones = response;
            }).catch(function (reason) {
                console.log(reason);
            });
        };

        ingresar_decretos.inicializar = function () {
            ingresar_decretos.obtener_secciones();
            ingresar_decretos.obtener_disposiciones();
        };

        ingresar_decretos.inicializar();

        ingresar_decretos.agregar_decreto_documento = function (decreto) {
            var flag = _.find(ingresar_decretos.documento.decretos, function (objDecreto) {
				return objDecreto.decreto_documento_id == decreto.decreto_documento_id;
			});

            if (flag) {
                messageFct.message("Ya existe el mismo decreto registrado por favor seleccione uno distinto");
            } else {
                var data = $.param({
                    documento_id : ingresar_decretos.documento.documento_id,
                    seccion_id : decreto.seccion_id,
                    fecha_decreto : $filter('date')(new Date(), 'yyyy-MM-dd HH:mm:ss'),
                    estado : 1,
                    opcion : 'registrar_decreto_documento'
                });

                documentoFct.saveDecretoDocumento(data).then(function (response) {
                    if (response.estado == 1) {
                        messageFct.message('Se ingresó correctamente el decreto -> '+decreto.seccion);
                        ingresar_decretos.decreto = undefined;

                        ingresar_decretos.documento.decretos.push({
                            decreto_documento_id : response.data.decreto_documento_id,
                            documento_id : response.data.documento_id,
                            seccion_id : response.data.seccion_id,
                            seccion : response.data.seccion,
                            fecha_decreto : new Date(response.data.fecha_decreto),
                            estado: response.data.estado
                        });
                    }  else {
                        messageFct.message("Ocurrió un error al intentar ingresar el decreto");
                    }
                }).catch(function (reason) {
                    console.log(reason);
                });
            }
        };

        ingresar_decretos.agregar_disposicion_documento = function (disposicion) {
            var flag = _.find(ingresar_decretos.documento.disposiciones, function (objDisposicion) {
				return objDisposicion.documento_disposicion_id == disposicion.documento_disposicion_id;
			});

            if (flag) {
                messageFct.message("Ya existe la misma disposición registrada porfavor selecciona una diferente");
            } else {
                var data = $.param({
                    documento_id : ingresar_decretos.documento.documento_id,
                    disposicion_id : disposicion.disposicion_id,
                    fecha_disposicion : $filter('date')(new Date(), 'yyyy-MM-dd HH:mm:ss'),
                    estado : 1,
                    opcion : 'registrar_disposicion_documento'
                });

                documentoFct.saveDisposicionDocumento(data).then(function (response) {
                    if (response.estado == 1) {
                        messageFct.message('Se ingresó correctamente el decreto -> '+decreto.seccion);
                        ingresar_decretos.disposicion = undefined;

                        ingresar_decretos.documento.disposiciones.push({
                            documento_disposicion_id : response.data.documento_disposicion_id,
                            documento_id : response.data.documento_id,
                            disposicion_id : response.data.disposicion_id,
                            disposicion : response.data.disposicion,
                            fecha_disposicion : new Date(response.data.fecha_disposicion),
                            estado: response.data.estado
                        });
                    }  else {
                        messageFct.message("Ocurrió un error al intentar ingresar el decreto");
                    }
                }).catch(function (reason) {
                    console.log(reason);
                });
            }
        };

        ingresar_decretos.eliminar_decreto_documento = function (decreto) {
            documentoFct.deleteDecretoDocumento(decreto.decreto_documento_id).then(function (response) {
                if (response.estado == 1) {
                    messageFct.message('Se eliminó correctamente el decreto -> '+decreto.seccion);
                    ingresar_decretos.decreto = undefined;

                    ingresar_decretos.documento.decretos = _.without(ingresar_decretos.documento.decretos, _.findWhere(ingresar_decretos.documento.decretos, {decreto_documento_id: decreto.decreto_documento_id}));
                }  else {
                    messageFct.message("Ocurrió un error al intentar ingresar el decreto");
                }
            }).catch(function (reason) {
                console.log(reason);
            });
        };

        ingresar_decretos.eliminar_disposicion_documento = function (disposicion) {
            documentoFct.deleteDecretoDocumento(disposicion.documento_disposicion_id).then(function (response) {
                if (response.estado == 1) {
                    messageFct.message('Se eliminó correctamente la disposición -> '+disposicion.disposicion);
                    ingresar_decretos.disposicion = undefined;

                    ingresar_decretos.documento.disposiciones = _.without(ingresar_decretos.documento.disposiciones, _.findWhere(ingresar_decretos.documento.disposiciones, {documento_disposicion_id: disposicion.documento_disposicion_id}));
                }  else {
                    messageFct.message("Ocurrió un error al intentar ingresar la disposición");
                }
            }).catch(function (reason) {
                console.log(reason);
            });
        };
    }

    function verEstadoCtrlPrtl ($uibModalInstance, documento) {
        var ver_estado = this;

        ver_estado.documento = documento;

        ver_estado.cerrar = function () {
            $uibModalInstance.dismiss();
        };
    }

    function cambiarAdjuntoCtrlPrtl ($uibModalInstance, Upload, messageFct, documento) {
        var cambiar_adjunto = this;

        cambiar_adjunto.documento = documento;

        cambiar_adjunto.cerrar = function () {
            $uibModalInstance.dismiss();
        };

        cambiar_adjunto.guardar_adjunto = function(adjunto){
            if (adjunto) {
                cambiar_adjunto.cargar_adjunto(adjunto);
            }
        };

        cambiar_adjunto.cargar_adjunto = function (file) {
            Upload.upload({
                url : 'ServletArchivo',
                data: {file : file}
            }).then(function (resp) {
                if(resp.data.estado === 1){
                    var data = $.param({
                        url_archivo : resp.data.adjunto,
                        documento_id : cambiar_adjunto.documento.documento_id,
                        opcion : 'cambiar_adjunto'
        			});

                    documentoFct.changeAdjunto(data).then(function (response) {
                        if (response.estado == 1) {
        					messageFct.message('Se cambió de adjunto al documento correctamente -> '+resp.data.documento_id);

        					$uibModalInstance.close(true);
        				}  else {
        					messageFct.message("Ocurrió un error al intentar cambiar el adjunto");
        				}
                    }).catch(function (reason) {
                        console.log(reason);
                    });
                } else {
                    messageFct.message('Ocurrió un error al intentar cargar el archivo');
                }
            }, function (resp) {
                console.log('Estado de error : ' + resp.status);
            }, function (evt) {
                var progreso_carga = parseInt(100.0 * evt.loaded / evt.total);

                cambiar_adjunto.progreso = 'Subiendo : ' + progreso_carga + '% ';
                cambiar_adjunto.valor = progreso_carga;
            });
        };
    }

    function messageCtrlPrtl ($uibModalInstance, $sce, message, callback, button) {
		var alert = this;

		callback = callback || null;

		alert.button = button;
		alert.message = $sce.trustAsHtml(message);

		alert.close = function () {
			$uibModalInstance.dismiss();
		};

		alert.success = function () {
			$uibModalInstance.close();
		};

		if(callback){
			alert.callback = callback;
		}
	}
})();
